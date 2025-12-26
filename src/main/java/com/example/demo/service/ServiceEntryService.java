package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate start,
            LocalDate end
    );

    List<ServiceEntry> findByGarageAndMinOdometer(long garageId, int minOdometer);

    // ✅ REQUIRED
    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
}
