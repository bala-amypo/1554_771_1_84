package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {
        ServiceEntry entry = serviceEntryRepository.findById(part.getServiceEntry().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Service entry not found"));
        if (part.getQuantity() <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (part.getCost().doubleValue() <= 0) throw new IllegalArgumentException("Cost must be positive");
        part.setServiceEntry(entry);
        return servicePartRepository.save(part);
    }

    @Override
    public Optional<ServicePart> getPartById(Long id) {
        return servicePartRepository.findById(id)
                .or(() -> { throw new ResourceNotFoundException("Service part not found"); });
    }

    @Override
    public List<ServicePart> getPartsForService(Long serviceEntryId) {
        return servicePartRepository.findByServiceEntryId(serviceEntryId);
    }
}
