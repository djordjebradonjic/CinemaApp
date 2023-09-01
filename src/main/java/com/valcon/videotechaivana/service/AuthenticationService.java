package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.LoginResponseDTO;
import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.dto.UserResponseDTO;

public interface AuthenticationService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    LoginResponseDTO login(String username, String password);
}
