package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int year;
    private Long ownerid;
    private Timestamp createdAt;
    private boolean active;

    public Vehicle() {}

    public Vehicle(Long id, String name, int year, Long ownerid, Timestamp createdAt, boolean active) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.ownerid = ownerid;
        this.createdAt = createdAt;
        this.active = active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Long getOwnerid() { return ownerid; }
    public void setOwnerid(Long ownerid) { this.ownerid = ownerid; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
