package com.valcon.videotechaivana.service.impl;

import com.valcon.videotechaivana.dto.UserRequestDTO;
import com.valcon.videotechaivana.dto.UserResponseDTO;
import com.valcon.videotechaivana.mapper.UserMapper;
import com.valcon.videotechaivana.model.Role;
import com.valcon.videotechaivana.model.User;
import com.valcon.videotechaivana.repository.RoleRepository;
import com.valcon.videotechaivana.service.AuthenticationService;
import com.valcon.videotechaivana.service.TokenService;
import com.valcon.videotechaivana.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



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
    public String login(String username, String password) {
        User user = userService.getByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }
        return tokenService.generateToken(user);
    }

}
