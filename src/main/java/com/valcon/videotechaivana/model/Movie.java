package com.valcon.videotechaivana.model;

import com.valcon.videotechaivana.model.enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String director;

    @ElementCollection(targetClass = Genre.class)
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private List<Genre> genres;

    @Column(nullable = false)
    private Integer duration;
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


