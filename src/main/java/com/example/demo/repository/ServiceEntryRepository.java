package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(com.example.demo.model.Vehicle vehicle);
    List<ServiceEntry> findByVehicleId(Long vehicleId);
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer);
    List<ServiceEntry> findByVehicleAndDateRange(Long vehicleId, java.time.LocalDate from, java.time.LocalDate to);
}
