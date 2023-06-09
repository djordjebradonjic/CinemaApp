package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {
    String generateToken(User user);

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

}
