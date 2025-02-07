package com.cinema.videotecha.mapper;

import com.cinema.videotecha.dto.ReservationResponseDTO;
import com.cinema.videotecha.model.Reservation;

public final class ReservationMapper {

    private ReservationMapper() {
    }

    public static ReservationResponseDTO mapToDTO(Reservation reservation){
        return new ReservationResponseDTO(reservation.getId(),UserMapper.mapToDTO(reservation.getUser()), ProjectionMapper.mapToDTO(reservation.getProjection()),reservation.getNumberOfTickets());
    }

}
