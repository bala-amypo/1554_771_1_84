package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.service.ServiceEntryService;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public ServiceEntryController(ServiceEntryService serviceEntryService,
                                  VehicleRepository vehicleRepository) {
        this.serviceEntryService = serviceEntryService;
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        Long vehicleId = entry.getVehicleId();
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        entry.setVehicleId(vehicle.getId());
        return serviceEntryService.saveServiceEntry(entry); // ensure saveServiceEntry() exists in your service
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getServiceEntriesByVehicleAndDateRange(
            @PathVariable Long vehicleId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return serviceEntryService.getServiceEntriesByVehicleAndDateRange(vehicleId, start, end);
    }
}
