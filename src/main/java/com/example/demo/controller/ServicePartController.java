package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartController(ServicePartService servicePartService,
                                 ServiceEntryRepository serviceEntryRepository) {
        this.servicePartService = servicePartService;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @PostMapping
    public ServicePart createServicePart(@RequestBody ServicePart servicePart) {
        Long serviceEntryId = servicePart.getServiceEntry().getId();
        ServiceEntry serviceEntry = serviceEntryRepository.findById(serviceEntryId)
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found"));
        servicePart.setServiceEntry(serviceEntry);
        return servicePartService.createPart(servicePart);
    }
}
