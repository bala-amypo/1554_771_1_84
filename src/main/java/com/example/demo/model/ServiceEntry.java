package com.example.demo.model;

import java.security.Timestamp;
import java.sql.Date;

import org.hibernate.mapping.ManyToOne;

public class ServiceEntry {
    private long id;
    private  ManyToOne  vehicle;
    private ManyToOne  garage;
    private String serviceType;
    private Date serviceDate;
    private Integer odometerReading;
    private String description;
    private Timestamp recordedAt;
    
    public ServiceEntry(long id, ManyToOne vehicle, ManyToOne garage, String serviceType, Date serviceDate,
            Integer odometerReading, String description, Timestamp recordedAt) {
        this.id = id;
        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.description = description;
        this.recordedAt = recordedAt;
    }
    public ServiceEntry(){

    }
    public long getId() {
        return id;
    }
    public ManyToOne getVehicle() {
        return vehicle;
    }
    public ManyToOne getGarage() {
        return garage;
    }
    public String getServiceType() {
        return serviceType;
    }
    public Date getServiceDate() {
        return serviceDate;
    }
    public Integer getOdometerReading() {
        return odometerReading;
    }
    public String getDescription() {
        return description;
    }
    public Timestamp getRecordedAt() {
        return recordedAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setVehicle(ManyToOne vehicle) {
        this.vehicle = vehicle;
    }
    public void setGarage(ManyToOne garage) {
        this.garage = garage;
    }
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRecordedAt(Timestamp recordedAt) {
        this.recordedAt = recordedAt;
    }
    
    
    
}