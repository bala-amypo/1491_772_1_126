package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final String secretKey = "amyposupersecretkey";

    private static final String SECURE_SECRET =
            "THIS_IS_A_SUPER_SECURE_256_BIT_SECRET_KEY_FOR_JWT_TOKEN";

    private final Key key = Keys.hmacShaKeyFor(SECURE_SECRET.getBytes());

    private final long expirationMs = 3600000;

    public String generateToken(Long id, String email, String role) {
        return Jwts.builder()
                .claim("id", id)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256) 
                .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) 
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
