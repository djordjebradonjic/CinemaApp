package com.valcon.videotechaivana.mapper;

import com.valcon.videotechaivana.dto.TheaterResponseDTO;
import com.valcon.videotechaivana.model.Theater;

public final class TheaterMapper {
    private TheaterMapper() {
    }

    public static TheaterResponseDTO mapToDTO(Theater theater) {
        return new TheaterResponseDTO(theater.getId(), theater.getName(), theater.getCapacity());
    }

}
