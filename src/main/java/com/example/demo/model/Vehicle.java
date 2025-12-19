package com.example.demo.model;

import java.sql.Timestamp;
import jakarta.persistence.Entity;

@Entity
public class Vehicle {

    private Long id;
    private String name;
    private int year;
    private Long ownerid;
    private Timestamp createdAt;

    public Vehicle() {
    }
    private boolean active;

public boolean isActive() {
    return active;
}

public void setActive(boolean active) {
    this.active = active;
}

    
    public Vehicle(Long id, String name, int year, Long ownerid, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.ownerid = ownerid;
        this.createdAt = createdAt;
    }

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
}
