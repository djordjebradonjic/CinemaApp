package com.valcon.videotechaivana.dto;

import com.valcon.videotechaivana.model.enums.Genre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MovieRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Director is mandatory")
    private String director;
    @NotEmpty(message = "Genre of movie is mandatory")
    private List<Genre> genres = new ArrayList<>();
    @NotNull(message = "Duration of movie is mandatory")
    @Min(value = 15, message = "Invalid duration of movie")
    private Integer duration;
    @NotBlank(message = "Description is mandatory")
    private String description;

    public MovieRequestDTO() {
    }

    public MovieRequestDTO(String name, String director, List<Genre> genres, Integer duration, String description) {
        this.name = name;
        this.director = director;
        this.genres = genres;
        this.duration = duration;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}
