package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.MovieRequestDTO;
import com.valcon.videotechaivana.dto.MovieResponseDTO;
import com.valcon.videotechaivana.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public MovieResponseDTO create(@Valid @RequestBody MovieRequestDTO movieRequestDTO) {
        return movieService.create(movieRequestDTO);

    }

    @GetMapping("/{id}")
    public MovieResponseDTO getById(@PathVariable Long id) {
        return movieService.getById(id);
    }


    @GetMapping
    public List<MovieResponseDTO> getAll() {
        return movieService.getAll();
    }


    @PutMapping("/{id}")
    public MovieResponseDTO update(@Valid @RequestBody MovieRequestDTO movieRequestDTO, @PathVariable Long id) {
        return movieService.update(movieRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }


}
