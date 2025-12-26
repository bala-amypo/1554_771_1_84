package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service  
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    // ✅ Constructor injection REQUIRED
    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {

        Long serviceEntryId = part.getServiceEntry().getId();

        ServiceEntry entry = serviceEntryRepository.findById(serviceEntryId)
                .orElseThrow(() ->
                        new EntityNotFoundException("ServiceEntry not found"));

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        part.setServiceEntry(entry);
        return servicePartRepository.save(part);
    }
}
