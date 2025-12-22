package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    // Custom query method to find service entries by vehicle and date range
    List<ServiceEntry> findByVehicleIdAndStartDateBetween(Long vehicleId, LocalDate startDate, LocalDate endDate);
}
