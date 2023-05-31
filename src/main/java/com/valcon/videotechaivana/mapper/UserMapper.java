package com.valcon.videotechaivana.mapper;

import com.valcon.videotechaivana.dto.UserResponseDTO;
import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.model.User;
import com.valcon.videotechaivana.model.enums.UserRole;


public final class UserMapper {
    private UserMapper() {
    }

    public static User mapToEntity(UserRequestDTO userRequestDTO) {
        UserRole userRole = UserRole.valueOf(userRequestDTO.getUserRole());
        return new User(userRequestDTO.getUsername(), userRequestDTO.getPassword(), userRequestDTO.getName(), userRequestDTO.getSurname(), userRequestDTO.getEmail(), userRole);
    }

    public static UserResponseDTO mapToDTO(User user) {
        String userRole = user.getUserRole().toString();
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getName(), user.getSurname(), userRole);

    }

}
