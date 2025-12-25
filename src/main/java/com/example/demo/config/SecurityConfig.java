package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.config.http.SessionCreationPolicy;

import com.example.demo.security.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // ✅ CREATE JwtUtil BEAN
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    // ✅ CREATE JwtAuthenticationFilter BEAN
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtUtil jwtUtil) {
        return new JwtAuthenticationFilter(jwtUtil);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtAuthenticationFilter jwtFilter)
            throws Exception {

        http
            // Disable CSRF for REST
            .csrf(csrf -> csrf.disable())

            // ✅ REQUIRED FOR AMYPO
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            // Stateless JWT
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // ✅ ACCESS RULES
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/", "/index.html", "/error",
                    "/status", "/proxy/**",
                    "/swagger-ui/**", "/v3/api-docs/**",
                    "/auth/**"
                ).permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            )

            // ✅ ADD JWT FILTER
            .addFilterBefore(jwtFilter,
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
