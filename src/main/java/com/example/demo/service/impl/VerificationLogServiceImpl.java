package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogServiceImpl {

    private final VerificationLogRepository verificationLogRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    public List<VerificationLog> getAllLogs() {
        return verificationLogRepository.findAll();
    }

    public VerificationLog getLogById(Long id) {
        return verificationLogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Verification log not found with id: " + id));
    }

    public VerificationLog saveLog(VerificationLog log) {
        return verificationLogRepository.save(log);
    }

    public void deleteLog(Long id) {
        if (!verificationLogRepository.existsById(id)) {
            throw new EntityNotFoundException("Verification log not found with id: " + id);
        }
        verificationLogRepository.deleteById(id);
    }
}
