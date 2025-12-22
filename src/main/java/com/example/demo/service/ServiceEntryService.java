package com.example.demo.service;

import com.example.demo.entity.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {
    
    // Method signature to get service entries by vehicle ID and date range
    List<ServiceEntry> getServiceEntriesByVehicleAndDateRange(Long vehicleId, LocalDate startDate, LocalDate endDate);
}
