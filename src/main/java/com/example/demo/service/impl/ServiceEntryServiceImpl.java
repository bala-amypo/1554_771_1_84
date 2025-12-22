package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    // Constructor injection for the repositories
    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository,
                                   GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        // Load Vehicle by id from entry
        Long vehicleId = entry.getVehicle() != null ? entry.getVehicle().getId() : null;
        if (vehicleId == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        // Load Garage by id from entry
        Long garageId = entry.getGarage() != null ? entry.getGarage().getId() : null;
        if (garageId == null) {
            throw new EntityNotFoundException("Garage not found");
        }
        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        // Reject inactive vehicles (message must contain "active vehicles")
        if (!vehicle.isActive()) {
            throw new IllegalArgumentException("Service entries can be created only for active vehicles");
        }

        // Enforce non-decreasing odometer (message must contain ">=")
        Optional<ServiceEntry> lastEntryOpt =
                serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
        if (lastEntryOpt.isPresent()
                && entry.getOdometerReading() != null
                && entry.getOdometerReading() < lastEntryOpt.get().getOdometerReading()) {
            throw new IllegalArgumentException("Odometer reading must be >= previous reading");
        }

        // Disallow future serviceDate (message must contain "future")
        LocalDate serviceDate = entry.getServiceDate();
        if (serviceDate != null && serviceDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in the future");
        }

        // Attach managed entities
        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
