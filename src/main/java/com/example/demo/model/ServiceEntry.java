package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicleId;  // The vehicle for which this service entry is made

    private LocalDate startDate;  // Service start date
    private LocalDate endDate;    // Service end date

    // Default constructor
    public ServiceEntry() {}

    // Constructor with parameters
    public ServiceEntry(Long vehicleId, LocalDate startDate, LocalDate endDate) {
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ServiceEntry{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
