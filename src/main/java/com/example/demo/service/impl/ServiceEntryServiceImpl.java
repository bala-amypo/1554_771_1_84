package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEntryServiceImpl {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    public List<ServiceEntry> getAllEntries() {
        return serviceEntryRepository.findAll();
    }

    public ServiceEntry getEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service entry not found with id: " + id));
    }

    public ServiceEntry saveEntry(ServiceEntry entry) {
        Vehicle vehicle = entry.getVehicle();
        if (vehicle == null || !vehicle.isActive()) {
            throw new EntityNotFoundException("Associated vehicle is not active or missing");
        }
        return serviceEntryRepository.save(entry);
    }

    public void deleteEntry(Long id) {
        if (!serviceEntryRepository.existsById(id)) {
            throw new EntityNotFoundException("Service entry not found with id: " + id);
        }
        serviceEntryRepository.deleteById(id);
    }
}
