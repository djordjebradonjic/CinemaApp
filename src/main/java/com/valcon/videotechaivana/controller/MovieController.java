package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.MovieRequestDTO;
import com.valcon.videotechaivana.dto.MovieResponseDTO;
import com.valcon.videotechaivana.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/movies")
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
