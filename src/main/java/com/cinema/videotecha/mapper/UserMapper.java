package com.cinema.videotecha.mapper;

import com.cinema.videotecha.dto.UserRequestDTO;
import com.cinema.videotecha.dto.UserResponseDTO;
import com.cinema.videotecha.model.User;


public final class UserMapper {
    private UserMapper() {
    }

    public static User mapToEntity(UserRequestDTO userRequestDTO) {
        return new User(userRequestDTO.getUsername(), userRequestDTO.getPassword(), userRequestDTO.getName(), userRequestDTO.getSurname(), userRequestDTO.getEmail());
    }

    public static UserResponseDTO mapToDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getName(), user.getSurname(), user.getEmail(), user.getRole().getName());

    }

}
