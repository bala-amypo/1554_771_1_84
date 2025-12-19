package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface UserService {
    User registerUser(User user);
    AuthResponse loginUser(AuthRequest request);
    User getUserById(Long id);
    User findByEmail(String email);
    void deleteUserById(Long id);
}
