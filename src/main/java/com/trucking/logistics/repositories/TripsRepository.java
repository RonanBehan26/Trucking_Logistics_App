package com.trucking.logistics.repositories;

import com.trucking.logistics.entites.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TripsRepository extends JpaRepository<Trips, Long> {

    List<Trips> findByUserId(Long userId);

    Trips findByVehicleNumber(Long vehicleNumber);

    Trips findByDriverName(Long driverName);
}
