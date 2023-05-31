package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.ProjectionResponseDTO;
import com.valcon.videotechaivana.dto.ProjectionRequestDTO;
import com.valcon.videotechaivana.model.Projection;

import java.util.List;

public interface ProjectionService {
    ProjectionResponseDTO create(ProjectionRequestDTO projectionRequestDTO);

    List<ProjectionResponseDTO> getAllAvailable();

    ProjectionResponseDTO getById(Long id);

    Projection getOne(Long id);

    List<ProjectionResponseDTO> getAllActive();

    void deleteById(Long id);

}
