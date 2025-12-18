package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Dummy register method
    public AuthResponse register(AuthRequest request) {
        // Normally, you would save user to DB here
        return new AuthResponse("User registered successfully: " + request.getUsername());
    }

    // Dummy login method
    public AuthResponse login(AuthRequest request) {
        // Normally, you would check user credentials here
        return new AuthResponse("User logged in successfully: " + request.getUsername());
    }
}
