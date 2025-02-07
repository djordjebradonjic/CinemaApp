package com.cinema.videotecha.service;

import java.util.List;

import com.cinema.videotecha.dto.ProjectionRequestDTO;
import com.cinema.videotecha.dto.ProjectionResponseDTO;
import com.cinema.videotecha.model.Projection;

public interface ProjectionService {
    ProjectionResponseDTO create(ProjectionRequestDTO projectionRequestDTO);

    List<ProjectionResponseDTO> getAllAvailable();

    ProjectionResponseDTO getById(Long id);

    Projection getOne(Long id);

    List<ProjectionResponseDTO> getAllActive();

    void deleteById(Long id);

}
