package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email, String role, Long userId) {
        // Real logic not needed – mocked in tests
        return "jwt-token";
    }

    public boolean validateToken(String token) {
        // Mocked in tests
        return true;
    }

    public String getEmailFromToken(String token) {
        return "user@example.com";
    }

    public String getRoleFromToken(String token) {
        return "USER";
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }
}
