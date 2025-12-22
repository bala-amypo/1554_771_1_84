package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle; // Many ServiceEntries belong to one Vehicle

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "garage_id")
    private Garage garage; // Many ServiceEntries belong to one Garage

    private Long odometerReading; // Odometer reading at the time of service
    private LocalDate serviceDate; // Date of service

    // Constructor, Getters, Setters, equals(), hashCode(), toString() methods

    public ServiceEntry() {}

    public ServiceEntry(Vehicle vehicle, Garage garage, Long odometerReading, LocalDate serviceDate) {
        this.vehicle = vehicle;
        this.garage = garage;
        this.odometerReading = odometerReading;
        this.serviceDate = serviceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Long getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Long odometerReading) {
        this.odometerReading = odometerReading;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    @Override
    public String toString() {
        return "ServiceEntry{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", garage=" + garage +
                ", odometerReading=" + odometerReading +
                ", serviceDate=" + serviceDate +
                '}';
    }
}
