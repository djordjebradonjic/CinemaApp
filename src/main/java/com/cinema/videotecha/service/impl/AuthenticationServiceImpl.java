package com.cinema.videotecha.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cinema.videotecha.dto.LoginResponseDTO;
import com.cinema.videotecha.dto.UserRequestDTO;
import com.cinema.videotecha.dto.UserResponseDTO;
import com.cinema.videotecha.mapper.UserMapper;
import com.cinema.videotecha.model.Role;
import com.cinema.videotecha.model.User;
import com.cinema.videotecha.repository.RoleRepository;
import com.cinema.videotecha.service.AuthenticationService;
import com.cinema.videotecha.service.TokenService;
import com.cinema.videotecha.service.UserService;



@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    public AuthenticationServiceImpl(UserService userService, TokenService tokenService,
                                     PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userService = userService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }


    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        Role role = roleRepository.findByName("ROLE_REGISTERED")
                .orElseThrow(() -> new EntityNotFoundException("Role with this name doesn't exists."));

        User newUser = UserMapper.mapToEntity(userRequestDTO);
        newUser.setRole(role);

        return UserMapper.mapToDTO(userService.saveUser(newUser));
    }

    @Override
    public LoginResponseDTO login(String username, String password) {
        User user = userService.getByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }
        String token = tokenService.generateToken(user);
        return new LoginResponseDTO(token,user.getId());
    }

}
