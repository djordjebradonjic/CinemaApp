package com.cinema.videotecha.service;

import java.util.List;

import com.cinema.videotecha.dto.TheaterResponseDTO;
import com.cinema.videotecha.model.Theater;

public interface TheaterService {

    List<TheaterResponseDTO> getAll();

    TheaterResponseDTO getById(Long id);

    Theater getOne(Long id);
}
