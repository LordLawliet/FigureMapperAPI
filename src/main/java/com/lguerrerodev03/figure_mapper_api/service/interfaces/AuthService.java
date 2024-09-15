package com.lguerrerodev03.figure_mapper_api.service.interfaces;


import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.AuthResponse;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.AuthenticationRequest;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticationRequest request);
}
