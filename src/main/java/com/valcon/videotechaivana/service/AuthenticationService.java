package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.dto.UserResponseDTO;

public interface AuthenticationService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

    String login(String username, String password);
}
