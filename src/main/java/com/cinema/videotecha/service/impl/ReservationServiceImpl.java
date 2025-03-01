package com.cinema.videotecha.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.videotecha.dto.ReservationRequestDTO;
import com.cinema.videotecha.dto.ReservationResponseDTO;
import com.cinema.videotecha.exception.BusinessLogicException;
import com.cinema.videotecha.exception.ResourceNotFoundException;
import com.cinema.videotecha.mapper.ReservationMapper;
import com.cinema.videotecha.model.Projection;
import com.cinema.videotecha.model.Reservation;
import com.cinema.videotecha.model.User;
import com.cinema.videotecha.repository.ReservationRepository;
import com.cinema.videotecha.service.ProjectionService;
import com.cinema.videotecha.service.ReservationService;
import com.cinema.videotecha.service.UserService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final int MAX_NUMBER_OF_TICKETS = 5;
    private static final int DEADLINE_FOR_CANCELLING_IN_HOURS = 2;

    private final ReservationRepository reservationRepository;
    private final ProjectionService projectionService;
    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ProjectionService projectionService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.projectionService = projectionService;
        this.userService = userService;
    }


    @Override
    @Transactional
    public ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO) {

        int numberOfSeats = reservationRequestDTO.getNumberOfTickets();
        if (numberOfSeats > MAX_NUMBER_OF_TICKETS) {
            throw new BusinessLogicException("More than 5 tickets aren't allowed.");
        }

        Projection projection = projectionService.getOne(reservationRequestDTO.getProjectionId());
        User user = userService.getOne(reservationRequestDTO.getUserId());

        checkSeatAvailability(user, projection, numberOfSeats);

        int numberOfAvailableSeats = projection.getAvailableSeats();
        projection.setAvailableSeats(numberOfAvailableSeats - numberOfSeats);

        Reservation newReservation = new Reservation(numberOfSeats, user, projection);
        Reservation createdReservation = reservationRepository.save(newReservation);

        return ReservationMapper.mapToDTO(createdReservation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDTO> getAll() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationMapper::mapToDTO)
                .toList();
    }


    @Override
    @Transactional(readOnly = true)
    public ReservationResponseDTO getActiveById(Long id) {
        return reservationRepository.findByIdAndCanceledFalse(id)
                .map(ReservationMapper::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));
    }

    @Override
    @Transactional
    public void cancelById(Long id) {
        Reservation existingReservation = reservationRepository.findByIdAndCanceledFalse(id).orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));
        if (Duration.between(LocalDateTime.now(), existingReservation.getProjection().getStartTime()).toHours() < DEADLINE_FOR_CANCELLING_IN_HOURS) {
            throw new BusinessLogicException("Reservation can't be canceled because it starts less than 2 hours. ");
        }
        existingReservation.setCanceled(true);
        updateNumberOfAvailableSeats(existingReservation);
        reservationRepository.save(existingReservation);

    }

    private void checkSeatAvailability(User user, Projection projection, int numberOfSeats) {

        int numberOfReservedSeats = reservationRepository.findReservedSeatsByUserAndProjection(user.getId(), projection.getId());
        int currentAvailableSeats = projection.getAvailableSeats() - numberOfSeats;
        if (currentAvailableSeats < 0) {
            throw new BusinessLogicException("There are no enough seats");
        }
        if (numberOfReservedSeats + numberOfSeats > MAX_NUMBER_OF_TICKETS) {
            throw new BusinessLogicException("You can't make reservation for more tickets than allowed");
        }

    }

    private void updateNumberOfAvailableSeats(Reservation existingReservation) {
        int numberOfReservedSeats = existingReservation.getNumberOfTickets();
        int numberOfAvailableSeats = existingReservation.getProjection().getAvailableSeats();
        existingReservation.getProjection().setAvailableSeats(numberOfAvailableSeats + numberOfReservedSeats);
    }


}
