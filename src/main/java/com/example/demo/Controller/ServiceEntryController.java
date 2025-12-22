package com.example.demo.controller;

import com.example.demo.entity.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    @Autowired
    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // Endpoint to get service entries for a specific vehicle within a date range
    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getServiceEntriesByVehicleAndDateRange(
            @PathVariable Long vehicleId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return serviceEntryService.getServiceEntriesByVehicleAndDateRange(vehicleId, startDate, endDate);
    }
}
