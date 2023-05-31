package com.valcon.videotechaivana.repository;

import com.valcon.videotechaivana.model.Movie;
import com.valcon.videotechaivana.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    void deleteById(Long id);

    Optional<Movie> findByIdAndDeletedFalse(Long id);

    Optional<Movie> findByNameAndDeletedFalse(String name);

    boolean existsByIdAndDeletedFalse(Long id);

    List<Movie> findByDeletedFalse();


}
