package com.valcon.videotechaivana.controller;


import com.valcon.videotechaivana.dto.UserResponseDTO;
import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id){
        return userService.getById(id);
    }

}
