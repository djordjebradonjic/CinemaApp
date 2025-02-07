package com.cinema.videotecha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.videotecha.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
