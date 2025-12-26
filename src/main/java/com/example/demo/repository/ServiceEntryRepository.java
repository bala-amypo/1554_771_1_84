package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // used in controller/service
    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    );

    // REQUIRED BY TESTS ↓↓↓

    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByGarageAndOdometer(long garageId, int odometer);

    List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate from,
            LocalDate to
    );
}
