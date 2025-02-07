package com.cinema.videotecha.mapper;

import java.util.ArrayList;
import java.util.List;

import com.cinema.videotecha.dto.MovieRequestDTO;
import com.cinema.videotecha.dto.MovieResponseDTO;
import com.cinema.videotecha.model.Movie;
import com.cinema.videotecha.model.enums.Genre;

public final class MovieMapper {

    private MovieMapper() {
    }

    public static Movie mapToEntity(MovieRequestDTO movieRequestDTO) {

        return new Movie(movieRequestDTO.getName(), movieRequestDTO.getDirector(), movieRequestDTO.getGenres(), movieRequestDTO.getDuration(), movieRequestDTO.getDescription());
    }

    public static MovieResponseDTO mapToDTO(Movie movie) {
        List<String> listStringGenre = new ArrayList<>();
        for (Genre genre : movie.getGenres()) {
            String genreString = genre.toString();
            listStringGenre.add(genreString);
        }
        return new MovieResponseDTO(movie.getId(),movie.getName(), movie.getDirector(), listStringGenre, movie.getDuration(), movie.getDescription());
    }
}
