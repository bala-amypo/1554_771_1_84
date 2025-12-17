
package com.example.demo.model;

import java.security.Timestamp;

public class Vehicle {
    private long id;
    private String vin;
    private  String name;
    private String model;
    private int year;
    private long ownerid;
    private Boolean active;
    private Timestamp createdAt;
    public Vehicle(long id, String vin, String name, String model, int year, long ownerid, Boolean active,
            Timestamp createdAt) {
        this.id = id;
        this.vin = vin;
        this.name = name;
        this.model = model;
        this.year = year;
        this.ownerid = ownerid;
        this.active = active;
        this.createdAt = createdAt;
    }
    public Vehicle() {
    }
    public long getId() {
        return id;
    }
    public String getVin() {
        return vin;
    }
    public String getName() {
        return name;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public long getOwnerid() {
        return ownerid;
    }
    public Boolean getActive() {
        return active;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
     
    
}


