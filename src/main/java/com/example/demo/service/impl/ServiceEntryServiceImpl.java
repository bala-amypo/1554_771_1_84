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

    // Constructor injection for repositories
    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository,
                                   GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        // Load Vehicle by id from the entry's vehicle field
        Long vehicleId = entry.getVehicle() != null ? entry.getVehicle().getId() : null;
        if (vehicleId == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }

        // Fetch vehicle from the repository
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        // Load Garage by id from the entry's garage field
        Long garageId = entry.getGarage() != null ? entry.getGarage().getId() : null;
        if (garageId == null) {
            throw new EntityNotFoundException("Garage not found");
        }

        // Fetch garage from the repository
        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        // Reject inactive vehicles
        if (!vehicle.isActive()) {
            throw new IllegalArgumentException("Service entries can be created only for active vehicles");
        }

        // Enforce non-decreasing odometer readings
        Optional<ServiceEntry> lastEntryOpt =
                serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
        if (lastEntryOpt.isPresent()
                && entry.getOdometerReading() != null
                && entry.getOdometerReading() < lastEntryOpt.get().getOdometerReading()) {
            throw new IllegalArgumentException("Odometer reading must be >= previous reading");
        }

        // Disallow future service dates
        LocalDate serviceDate = entry.getServiceDate();
        if (serviceDate != null && serviceDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in the future");
        }

        // Set vehicle and garage to the entry
        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        // Save and return the service entry
        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
