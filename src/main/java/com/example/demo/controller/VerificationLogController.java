package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    private final VerificationLogService verificationLogService;
    private final ServiceEntryRepository serviceEntryRepository;

    public VerificationLogController(VerificationLogService verificationLogService,
                                     ServiceEntryRepository serviceEntryRepository) {
        this.verificationLogService = verificationLogService;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @PostMapping
    public VerificationLog createLog(@RequestBody VerificationLog log) {
        Long serviceEntryId = log.getServiceEntry().getId();
        ServiceEntry serviceEntry = serviceEntryRepository.findById(serviceEntryId)
                .orElseThrow(() -> new RuntimeException("ServiceEntry not found"));
        log.setServiceEntry(serviceEntry);
        log.setVerifiedAt(LocalDateTime.now());
        return verificationLogService.createLog(log);
    }
}
