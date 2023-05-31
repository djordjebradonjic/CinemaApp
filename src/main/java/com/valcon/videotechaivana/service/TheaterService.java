package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.TheaterResponseDTO;
import com.valcon.videotechaivana.model.Theater;

import java.util.List;

public interface TheaterService {

    List<TheaterResponseDTO> getAll();

    TheaterResponseDTO getById(Long id);

    Theater getOne(Long id);
}
