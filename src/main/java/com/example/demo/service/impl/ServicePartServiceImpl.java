package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository servicePartRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository) {
        this.servicePartRepository = servicePartRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {
        // Save the new ServicePart
        return servicePartRepository.save(part);
    }

    public List<ServicePart> getAllParts() {
        return servicePartRepository.findAll();
    }

    public ServicePart getPartById(Long id) {
        return servicePartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service part not found with id: " + id));
    }

    public void deletePart(Long id) {
        if (!servicePartRepository.existsById(id)) {
            throw new EntityNotFoundException("Service part not found with id: " + id);
        }
        servicePartRepository.deleteById(id);
    }
}
