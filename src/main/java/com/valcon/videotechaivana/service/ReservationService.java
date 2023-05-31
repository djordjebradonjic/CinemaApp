package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.ReservationResponseDTO;
import com.valcon.videotechaivana.dto.ReservationRequestDTO;

import java.util.List;

public interface ReservationService {

    ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO);

    List<ReservationResponseDTO> getAll();

    ReservationResponseDTO getActiveById(Long id);

    void cancelById(Long id);
}
