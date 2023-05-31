package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.ProjectionResponseDTO;
import com.valcon.videotechaivana.dto.ProjectionRequestDTO;
import com.valcon.videotechaivana.service.ProjectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projections")
public class ProjectionController {
    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProjectionResponseDTO create(@Valid @RequestBody ProjectionRequestDTO projectionRequestDTO) {
        return projectionService.create(projectionRequestDTO);
    }

    @GetMapping("/available")
    public List<ProjectionResponseDTO> getAllAvailable() {
        return projectionService.getAllAvailable();
    }

    @GetMapping("/{id}")
    public ProjectionResponseDTO getById(@PathVariable Long id) {
        return projectionService.getById(id);

    }

    @GetMapping
    public List<ProjectionResponseDTO> getAllActive() {
        return projectionService.getAllActive();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        projectionService.deleteById(id);
    }


}
