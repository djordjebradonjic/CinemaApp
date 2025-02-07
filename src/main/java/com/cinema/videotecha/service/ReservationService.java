package com.cinema.videotecha.service;

import java.util.List;

import com.cinema.videotecha.dto.ReservationRequestDTO;
import com.cinema.videotecha.dto.ReservationResponseDTO;

public interface ReservationService {

    ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO);

    List<ReservationResponseDTO> getAll();

    ReservationResponseDTO getActiveById(Long id);

    void cancelById(Long id);
}
