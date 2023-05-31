package com.valcon.videotechaivana.mapper;

import com.valcon.videotechaivana.dto.MovieRequestDTO;
import com.valcon.videotechaivana.dto.MovieResponseDTO;
import com.valcon.videotechaivana.model.enums.Genre;
import com.valcon.videotechaivana.model.Movie;

import java.util.ArrayList;
import java.util.List;

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
