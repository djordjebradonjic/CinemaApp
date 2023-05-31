package com.valcon.videotechaivana.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String director;
    private List<String> genres = new ArrayList<>();
    private Integer duration;
    private String description;

    private MovieResponseDTO() {
    }

    public MovieResponseDTO(Long id, String name, String director, List<String> genres, Integer duration, String description) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.genres = genres;
        this.duration = duration;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
