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
    public ServiceEntry save(ServiceEntry entry) {

        ServiceEntry last = serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(entry.getVehicle());

        if (last != null && entry.getOdometerReading() < last.getOdometerReading()) {
            throw new IllegalArgumentException("Odometer reading cannot be less than previous");
        }

        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getByVehicleId(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getByGarageAndMinOdometer(Long garageId, int minOdometer) {
        return serviceEntryRepository.findByGarageAndMinOdometer(garageId, minOdometer);
    }

    @Override
    public List<ServiceEntry> getByVehicleAndDateRange(
            Long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    ) {
        return serviceEntryRepository.findByVehicleAndDateRange(
                vehicleId, startDate, endDate
        );
    }
}
