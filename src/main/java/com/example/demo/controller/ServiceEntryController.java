package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;
    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    @PostMapping
    public ResponseEntity<ServiceEntry> createEntry(@RequestBody ServiceEntry entry) {
        return ResponseEntity.ok(serviceEntryService.createServiceEntry(entry));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<ServiceEntry>> getByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(serviceEntryService.getEntriesForVehicle(vehicleId));
    }
}
