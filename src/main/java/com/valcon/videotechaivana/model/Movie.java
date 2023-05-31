package com.valcon.videotechaivana.model;

import com.valcon.videotechaivana.model.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "Director is mandatory")
    @Column(nullable = false)
    private String director;

    @NotEmpty(message = "Genre of movie is mandatory")
    @ElementCollection(targetClass = Genre.class)
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private List<Genre> genres;

    @NotNull(message = "Duration of movie is mandatory")
    @Min(value = 15, message = "Invalid duration of movie")
    @Column(nullable = false)
    private Integer duration;
    @NotBlank(message="Description is mandatory")
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "movie")
    private List<Projection> projections = new ArrayList<>();

    public Movie() {
    }

    public Movie(String name, String director, List<Genre> genres, Integer duration, String description) {
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


    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }


}


