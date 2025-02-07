package com.cinema.videotecha.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cinema.videotecha.dto.UserResponseDTO;
import com.cinema.videotecha.exception.ResourceAlreadyExistsException;
import com.cinema.videotecha.exception.ResourceNotFoundException;
import com.cinema.videotecha.mapper.UserMapper;
import com.cinema.videotecha.model.User;
import com.cinema.videotecha.repository.UserRepository;
import com.cinema.videotecha.service.UserService;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new ResourceAlreadyExistsException("User", "id", existingUser.get().getId());
        }
        return userRepository.save(user);

    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToDTO)
                .toList();
    }

    @Override
    public UserResponseDTO getById(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return UserMapper.mapToDTO(existingUser);
    }

    @Override
    public User getOne(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(format("Not found user with username %s", username)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(format("Not found user with username %s", username)));
    }


}
