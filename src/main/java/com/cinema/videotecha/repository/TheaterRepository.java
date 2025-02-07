package com.cinema.videotecha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.videotecha.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
