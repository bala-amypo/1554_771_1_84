package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    @Query("""
        SELECT s FROM ServiceEntry s
        WHERE s.garage.id = :garageId
        AND s.odometer >= :minOdometer
    """)
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") long garageId,
            @Param("minOdometer") int minOdometer
    );

    @Query("""
        SELECT s FROM ServiceEntry s
        WHERE s.vehicle.id = :vehicleId
        AND s.serviceDate BETWEEN :startDate AND :endDate
    """)
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") long vehicleId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
