// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.dto.ApiResponse;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     @PostMapping("/register")
//     public ApiResponse register(@RequestBody RegisterRequest request) {
//         return new ApiResponse(true, "User registered successfully");
//     }

//     @PostMapping("/login")
//     public ApiResponse login(@RequestBody LoginRequest request) {
//         return new ApiResponse(true, "JWT_TOKEN_SAMPLE");
//     }
// }
