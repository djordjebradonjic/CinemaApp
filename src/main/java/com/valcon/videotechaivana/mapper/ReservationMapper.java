package com.valcon.videotechaivana.mapper;

import com.valcon.videotechaivana.dto.ReservationResponseDTO;
import com.valcon.videotechaivana.model.Reservation;

public final class ReservationMapper {

    private ReservationMapper() {
    }

    public static ReservationResponseDTO mapToDTO(Reservation reservation){
        return new ReservationResponseDTO(reservation.getId(),UserMapper.mapToDTO(reservation.getUser()), ProjectionMapper.mapToDTO(reservation.getProjection()),reservation.getNumberOfTickets());
    }

}
