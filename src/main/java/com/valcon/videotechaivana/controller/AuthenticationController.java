package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.LoginDTO;
import com.valcon.videotechaivana.dto.LoginResponseDTO;
import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.dto.UserResponseDTO;
import com.valcon.videotechaivana.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return authenticationService.registerUser(userRequestDTO);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginDTO dto) {
        return authenticationService.login(dto.getUsername(), dto.getPassword());
    }

}
