package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.dto.UserResponseDTO;
import com.valcon.videotechaivana.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface UserService extends UserDetailsService {

    User saveUser(User newUser);
    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    User getOne(Long id);
    User getByUsername(String username);



}
