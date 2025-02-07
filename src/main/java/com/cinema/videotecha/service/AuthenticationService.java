package com.cinema.videotecha.service;

import com.cinema.videotecha.dto.LoginResponseDTO;
import com.cinema.videotecha.dto.UserRequestDTO;
import com.cinema.videotecha.dto.UserResponseDTO;

public interface AuthenticationService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    LoginResponseDTO login(String username, String password);
}
