package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {  // Implementing the interface

    private final VerificationLogRepository verificationLogRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) { // Implementing the createLog method
        return verificationLogRepository.save(log);
    }

    public List<VerificationLog> getAllLogs() {
        return verificationLogRepository.findAll();
    }

    public VerificationLog getLogById(Long id) {
        return verificationLogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Verification log not found with id: " + id));
    }

    public void deleteLog(Long id) {
        if (!verificationLogRepository.existsById(id)) {
            throw new EntityNotFoundException("Verification log not found with id: " + id);
        }
        verificationLogRepository.deleteById(id);
    }
}
