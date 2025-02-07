package com.cinema.videotecha.mapper;

import com.cinema.videotecha.dto.TheaterResponseDTO;
import com.cinema.videotecha.model.Theater;

public final class TheaterMapper {
    private TheaterMapper() {
    }

    public static TheaterResponseDTO mapToDTO(Theater theater) {
        return new TheaterResponseDTO(theater.getId(), theater.getName(), theater.getCapacity());
    }

}
