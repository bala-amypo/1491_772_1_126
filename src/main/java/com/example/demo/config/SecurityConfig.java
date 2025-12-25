package com.example.demo.config;

import com.example.demo.security.JwtUtil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 🔑 Required for AuthController
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 🔑 Required for JwtAuthenticationFilter constructor
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    // 🛑 SECURITY DISABLED (ACCESS GUARANTEED)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // ✅ Allow iframe / AmyPo proxy
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            // ✅ ALLOW EVERYTHING (NO 403)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
