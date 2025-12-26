package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service  
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    // ✅ Constructor injection REQUIRED
    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                  VehicleRepository vehicleRepository,
                                  GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Long vehicleId = entry.getVehicle().getId();
        Long garageId = entry.getGarage().getId();

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (!vehicle.getActive()) {
            throw new IllegalArgumentException("Only active vehicles allowed");
        }

        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be future");
        }

        serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException(
                                "Odometer reading must be >=");
                    }
                });

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
