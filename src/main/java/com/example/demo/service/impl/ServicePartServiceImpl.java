package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

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
    public ServicePart createPart(ServicePart servicePart) {

        Long serviceEntryId = servicePart.getServiceEntry().getId();

        ServiceEntry serviceEntry = serviceEntryRepository.findById(serviceEntryId)
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found"));

        servicePart.setServiceEntry(serviceEntry);

        return servicePartRepository.save(servicePart);
    }
}
