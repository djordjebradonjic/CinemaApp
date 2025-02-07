package com.cinema.videotecha.service;

import java.util.List;

import com.cinema.videotecha.dto.MovieRequestDTO;
import com.cinema.videotecha.dto.MovieResponseDTO;
import com.cinema.videotecha.model.Movie;


public interface MovieService {
    MovieResponseDTO create(MovieRequestDTO movieRequestDTO);

    MovieResponseDTO getById(Long id);

    List<MovieResponseDTO> getAll();

    Movie getOne(Long id);

    void deleteById(Long id);

    MovieResponseDTO update(MovieRequestDTO newMovie, Long id);

}
