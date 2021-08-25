package com.trucking.logistics.services;

import com.trucking.logistics.entites.Trips;

import java.util.List;

public interface TripsService {

    Long createTrips(Trips trips);

    void updateTrips(Trips trips, Long id);

    void deleteTrips(Long id);

    List<Trips> findAll();

    Trips findById(Long id);

    List <Trips> findByUserId(Long userId);

    Trips findByDriverName(Long driverName);

    Trips findByVehicleNumber(Long vehicleNumber);
}
