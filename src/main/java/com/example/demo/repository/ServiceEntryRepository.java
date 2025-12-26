package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByGarageAndMinOdometer(long garageId, int minOdometer);

    List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate start,
            LocalDate end
    );
}
