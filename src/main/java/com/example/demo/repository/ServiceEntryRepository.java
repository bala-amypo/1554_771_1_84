package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    List<ServiceEntry> findByVehicleAndDateRange(
            long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    );

    List<ServiceEntry> findByGarageAndOdometer(long garageId, int odometer);

    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
}
package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    @Query("SELECT s FROM ServiceEntry s WHERE s.garage.id = :garageId AND s.odometerReading > :minOdometer")
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") Long garageId,
            @Param("minOdometer") int minOdometer
    );

    @Query("SELECT s FROM ServiceEntry s WHERE s.vehicle.id = :vehicleId AND s.serviceDate BETWEEN :from AND :to")
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") Long vehicleId,
            @Param("from") LocalDate from,
            @Param("to") LocalDate to
    );
}
