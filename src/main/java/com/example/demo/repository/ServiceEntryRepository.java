package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // Custom query to find the latest service entry for a vehicle ordered by odometer reading (descending)
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    // Find all service entries for a specific vehicle (by vehicleId)
    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // Custom query to find entries for a specific garage with a minimum odometer reading
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer);

    // Find service entries for a specific vehicle and a date range
    List<ServiceEntry> findByVehicleAndDateRange(Long vehicleId, LocalDate from, LocalDate to);
}
