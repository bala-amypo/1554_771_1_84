// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.service.AuthService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private AuthService authService;

//     // Register new user
//     @PostMapping("/register")
//     public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
//         authService.register(authRequest);
//         return ResponseEntity.ok("User registered successfully");
//     }

//     // Login user
//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
//         AuthResponse authResponse = authService.login(authRequest);
//         return ResponseEntity.ok(authResponse);
//     }
// }
