package com.cinema.videotecha.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.cinema.videotecha.dto.MovieRequestDTO;
import com.cinema.videotecha.dto.MovieResponseDTO;
import com.cinema.videotecha.service.MovieService;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public MovieResponseDTO create(@Valid @RequestBody MovieRequestDTO movieRequestDTO) {
        return movieService.create(movieRequestDTO);

    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping("/{id}")
    public MovieResponseDTO getById(@PathVariable Long id) {
        return movieService.getById(id);
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REGISTERED')")
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    public List<MovieResponseDTO> getAll() {
        return movieService.getAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public MovieResponseDTO update(@Valid @RequestBody MovieRequestDTO movieRequestDTO, @PathVariable Long id) {
        return movieService.update(movieRequestDTO, id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }


}
