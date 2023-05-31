package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.MovieResponseDTO;
import com.valcon.videotechaivana.dto.MovieRequestDTO;
import com.valcon.videotechaivana.model.Movie;

import java.util.List;


public interface MovieService {
    MovieResponseDTO create(MovieRequestDTO movieRequestDTO);

    MovieResponseDTO getById(Long id);

    List<MovieResponseDTO> getAll();

    Movie getOne(Long id);

    void deleteById(Long id);

    MovieResponseDTO update(MovieRequestDTO newMovie, Long id);

}
