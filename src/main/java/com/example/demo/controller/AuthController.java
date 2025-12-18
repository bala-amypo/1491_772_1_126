package com.example.demo.controller;

import com.example.demo.entity.AuthRequest;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return authService.generateToken(request.getUsername(), request.getPassword());
    }
}
