package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.ProjectionResponseDTO;
import com.valcon.videotechaivana.dto.ProjectionRequestDTO;
import com.valcon.videotechaivana.service.ProjectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projections")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProjectionController {
    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProjectionResponseDTO create(@Valid @RequestBody ProjectionRequestDTO projectionRequestDTO) {
        return projectionService.create(projectionRequestDTO);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping("/available")
    public List<ProjectionResponseDTO> getAllAvailable() {
        return projectionService.getAllAvailable();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping("/{id}")
    public ProjectionResponseDTO getById(@PathVariable Long id) {
        return projectionService.getById(id);

    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping
    public List<ProjectionResponseDTO> getAllActive() {
        return projectionService.getAllActive();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        projectionService.deleteById(id);
    }


}
