package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    );

    List<ServiceEntry> findByGarageAndMinOdometer(
            long garageId,
            int minOdometer
    );
}
