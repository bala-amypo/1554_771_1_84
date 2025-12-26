package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // ✅ REQUIRED BY TESTS
    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry serviceEntry) {
        return serviceEntryService.save(serviceEntry);
    }

    // ✅ REQUIRED BY TESTS
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getEntriesForVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getByVehicleId(vehicleId);
    }
}
