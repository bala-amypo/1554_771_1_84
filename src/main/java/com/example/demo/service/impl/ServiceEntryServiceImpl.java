package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        return serviceEntryRepository.findByVehicleAndDateRange(
                vehicleId, startDate, endDate
        );
    }

    @Override
    public List<ServiceEntry> findByGarageAndMinOdometer(
            long garageId,
            int minOdometer
    ) {
        return serviceEntryRepository.findByGarageAndMinOdometer(
                garageId, minOdometer
        );
    }
}
