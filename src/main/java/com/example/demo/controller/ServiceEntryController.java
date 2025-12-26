package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // Create a new service entry
    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry serviceEntry) {
        return serviceEntryService.createServiceEntry(serviceEntry);
    }

    // Get all service entries for a vehicle
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getEntriesForVehicle(@PathVariable Long vehicleId) {
        return serviceEntryService.getEntriesForVehicle(vehicleId);
    }

    // Get service entries for a vehicle within date range
    @GetMapping("/vehicle/{vehicleId}/range")
    public List<ServiceEntry> getEntriesByVehicleAndDateRange(
            @PathVariable long vehicleId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return serviceEntryService.findByVehicleAndDateRange(
                vehicleId, startDate, endDate
        );
    }
}
