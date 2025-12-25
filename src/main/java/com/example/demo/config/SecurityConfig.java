package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // REST → disable CSRF
            .csrf(csrf -> csrf.disable())

            // ✅ REQUIRED FOR AMYPO (iframe / proxy)
            .headers(headers -> headers.frameOptions(frame -> frame.disable()))

            // JWT → stateless
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // ✅ ACCESS RULES (THIS FIXES 403)
            .authorizeHttpRequests(auth -> auth
                // AmyPo + Root
                .requestMatchers(
                    "/",
                    "/index.html",
                    "/error",
                    "/status",
                    "/proxy/**",

                    // Swagger
                    "/swagger-ui/**",
                    "/v3/api-docs/**",

                    // Auth APIs
                    "/auth/**"
                ).permitAll()

                // 🔒 Secure APIs
                .requestMatchers("/api/**").authenticated()

                // Everything else allowed
                .anyRequest().permitAll()
            )

            // JWT filter
            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}
