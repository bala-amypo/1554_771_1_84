package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry save(ServiceEntry entry);

    List<ServiceEntry> getByVehicleId(Long vehicleId);

    List<ServiceEntry> getByGarageAndMinOdometer(Long garageId, int minOdometer);

    List<ServiceEntry> getByVehicleAndDateRange(
            Long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    );
}
