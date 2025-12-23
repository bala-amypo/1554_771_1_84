package com.example.demo.service.impl;
import java.util.Optional;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository verificationLogRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository,
                                      ServiceEntryRepository serviceEntryRepository) {
        this.verificationLogRepository = verificationLogRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {
        ServiceEntry entry = serviceEntryRepository.findById(log.getServiceEntry().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Service entry not found"));
        log.setServiceEntry(entry);
        return verificationLogRepository.save(log);
    }

    @Override
    public Optional<VerificationLog> getLogById(Long id) {
        return verificationLogRepository.findById(id)
                .or(() -> { throw new ResourceNotFoundException("Verification log not found"); });
    }

    @Override
    public List<VerificationLog> getLogsForService(Long serviceEntryId) {
        return verificationLogRepository.findByServiceEntryId(serviceEntryId);
    }

    @Override
    public List<VerificationLog> getAllLogs() {
        return verificationLogRepository.findAll();
    }
}
