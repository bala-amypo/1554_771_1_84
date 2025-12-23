package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    @Autowired
    private VerificationLogService verificationLogService;

    @PostMapping
    public ResponseEntity<VerificationLog> createLog(@RequestBody VerificationLog log) {
        VerificationLog saved = verificationLogService.createLog(log);
        return ResponseEntity.ok(saved);
    }
}
