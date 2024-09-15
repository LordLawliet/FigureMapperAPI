package com.lguerrerodev03.figure_mapper_api.presentation.controller;


import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.AuthResponse;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.AuthenticationRequest;
import com.lguerrerodev03.figure_mapper_api.presentation.controller.models.RegisterRequest;
import com.lguerrerodev03.figure_mapper_api.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}

