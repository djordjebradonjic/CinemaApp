package com.cinema.videotecha.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.cinema.videotecha.model.User;

public interface TokenService {
    String generateToken(User user);

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

}
