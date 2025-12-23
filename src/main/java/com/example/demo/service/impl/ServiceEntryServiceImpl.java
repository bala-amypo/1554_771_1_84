package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;

import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    @Autowired
    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public List<ServiceEntry> getServiceEntriesByVehicleAndDateRange(Long vehicleId, LocalDate startDate, LocalDate endDate) {
        return serviceEntryRepository.findByVehicleIdAndStartDateBetween(vehicleId, startDate, endDate);
    }
}
