package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        garageRepository.findByGarageName(garage.getGarageName())
                .ifPresent(g -> { throw new IllegalArgumentException("Garage name already exists"); });
        return garageRepository.save(garage);
    }

    @Override
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id)
                .or(() -> { throw new ResourceNotFoundException("Garage not found"); });
    }

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Garage deactivateGarage(Long id) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Garage not found"));
        garage.setActive(false);
        return garageRepository.save(garage);
    }
}
