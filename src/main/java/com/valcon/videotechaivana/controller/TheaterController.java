package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.TheaterResponseDTO;
import com.valcon.videotechaivana.service.TheaterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<TheaterResponseDTO> getAll() {
        return theaterService.getAll();

    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public TheaterResponseDTO getById(@PathVariable Long id) {
        return theaterService.getById(id);
    }
}
