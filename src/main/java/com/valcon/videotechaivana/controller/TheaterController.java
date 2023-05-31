package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.TheaterResponseDTO;
import com.valcon.videotechaivana.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<TheaterResponseDTO> getAll() {
        return theaterService.getAll();

    }

    @GetMapping("/{id}")
    public TheaterResponseDTO getById(@PathVariable Long id) {
        return theaterService.getById(id);
    }
}
