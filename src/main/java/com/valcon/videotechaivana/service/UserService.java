package com.valcon.videotechaivana.service;

import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.dto.UserResponseDTO;
import com.valcon.videotechaivana.model.User;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface UserService {

    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    User getOne(Long id);

    UserResponseDTO register(UserRequestDTO userRequestDTO);
}
