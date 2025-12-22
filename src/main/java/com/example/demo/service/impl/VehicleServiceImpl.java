package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        // No VIN field in your model, so no VIN uniqueness check here
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        // Your Vehicle entity has no vin field, so this cannot really look up by VIN.
        // For now, throw not found to satisfy the interface.
        throw new EntityNotFoundException("Vehicle not found");
    }

    @Override
    public List<Vehicle> getVehiclesByOwner(Long ownerid) {
        return vehicleRepository.findByOwnerid(ownerid);
    }

    @Override
    public void deactivateVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        v.setActive(false);
        vehicleRepository.save(v);
    }
}
