package com.cinema.videotecha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.videotecha.model.Movie;
import com.cinema.videotecha.model.Projection;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    void deleteById(Long id);

    Optional<Movie> findByIdAndDeletedFalse(Long id);

    Optional<Movie> findByNameAndDeletedFalse(String name);

    boolean existsByIdAndDeletedFalse(Long id);

    List<Movie> findByDeletedFalse();


}
