package com.lguerrerodev03.figure_mapper_api.service.implementation;

import com.lguerrerodev03.figure_mapper_api.configuration.jwt.JwtService;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.Role;
import com.lguerrerodev03.figure_mapper_api.persistence.entity.User;
import com.lguerrerodev03.figure_mapper_api.persistence.repository.UserRepository;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.AuthResponse;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.AuthenticationRequest;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.RegisterRequest;
import com.lguerrerodev03.figure_mapper_api.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUserName(request.getUserName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .userId(user.getId())
                .build();
    }
}