package com.cinema.videotecha.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cinema.videotecha.dto.UserRequestDTO;
import com.cinema.videotecha.dto.UserResponseDTO;
import com.cinema.videotecha.model.User;

import java.util.List;


@Service
public interface UserService extends UserDetailsService {

    User saveUser(User newUser);
    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    User getOne(Long id);
    User getByUsername(String username);



}
