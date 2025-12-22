package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;

    private String email;
    private String password;
    private String role;
    private String username;  // Add this line for the username field

    // Default constructor
    public User() {}

    // Constructor with username
    public User(long id, String email, String password, String role, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
