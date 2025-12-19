package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl {

    private final ServicePartRepository servicePartRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository) {
        this.servicePartRepository = servicePartRepository;
    }

    public List<ServicePart> getAllParts() {
        return servicePartRepository.findAll();
    }

    public ServicePart getPartById(Long id) {
        return servicePartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service part not found with id: " + id));
    }

    public ServicePart savePart(ServicePart part) {
        return servicePartRepository.save(part);
    }

    public void deletePart(Long id) {
        if (!servicePartRepository.existsById(id)) {
            throw new EntityNotFoundException("Service part not found with id: " + id);
        }
        servicePartRepository.deleteById(id);
    }
}
