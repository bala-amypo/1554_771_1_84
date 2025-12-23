package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Garage;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.ServiceEntryService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository,
                                   GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Garage not found"));

        if (!vehicle.getActive()) throw new IllegalArgumentException("Only active vehicles allowed");
        if (!garage.getActive()) throw new IllegalArgumentException("Garage is inactive");
        if (entry.getServiceDate().isAfter(LocalDate.now())) throw new IllegalArgumentException("Service date cannot be future");

        Optional<ServiceEntry> lastEntry = serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
        lastEntry.ifPresent(e -> {
            if (entry.getOdometerReading() < e.getOdometerReading())
                throw new IllegalArgumentException("Odometer reading must be >=");
        });

        entry.setVehicle(vehicle);
        entry.setGarage(garage);
        return serviceEntryRepository.save(entry);
    }

    @Override
    public Optional<ServiceEntry> getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .or(() -> { throw new ResourceNotFoundException("Service entry not found"); });
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    @Override
    public ServiceEntry updateServiceEntry(Long id, ServiceEntry entry) {
        ServiceEntry existing = serviceEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service entry not found"));
        existing.setServiceType(entry.getServiceType());
        existing.setOdometerReading(entry.getOdometerReading());
        existing.setServiceDate(entry.getServiceDate());
        existing.setCost(entry.getCost());
        existing.setNotes(entry.getNotes());
        return serviceEntryRepository.save(existing);
    }
}
