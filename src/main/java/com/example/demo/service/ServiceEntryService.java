package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.util.List;

public interface ServiceEntryService {

    // Method to create a new service entry
    ServiceEntry createServiceEntry(ServiceEntry entry);

    // Method to get all service entries for a specific vehicle
    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);
}
