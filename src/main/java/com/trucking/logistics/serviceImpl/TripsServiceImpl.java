package com.trucking.logistics.serviceImpl;

import com.trucking.logistics.entites.Booking;
import com.trucking.logistics.entites.Trips;
import com.trucking.logistics.repositories.TripsRepository;
import com.trucking.logistics.services.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripsServiceImpl implements TripsService {

    @Autowired
    private TripsRepository tripsRepository;

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @Override
    public Long createTrips(Trips trips) {
        Long userId = trips.getUserId();
        if(userId != null) {
            List<Booking> bookingUserId = bookingServiceImpl.findBookingUserId(userId);
            if (bookingUserId != null && bookingUserId.size() > 0) {
                    return tripsRepository.save(trips).getId();
                }
            }
        return null;
    }

    @Override
    public void updateTrips(Trips trips, Long id) {
        Trips tripsFromDb = tripsRepository.findById(id).get();
        //System.out.println(userFromDb.toString());
        if(trips.getTripTime() != null) {
            tripsFromDb.setTripTime(trips.getTripTime());
        }
        if(trips.getPickUpFrom() != null) {
            tripsFromDb.setPickUpFrom(trips.getPickUpFrom());
        }
        if(trips.getDropTo() != null) {
            tripsFromDb.setDropTo(trips.getDropTo());
        }
        if(trips.getDriverName() != null) {
            tripsFromDb.setDriverName(trips.getDriverName());
        }
        if(trips.getVehicleNumber() != null) {
            tripsFromDb.setVehicleNumber(trips.getVehicleNumber());
        }
        if(trips.getDriverPhoneNumber() != null) {
            tripsFromDb.setDriverPhoneNumber(trips.getDriverPhoneNumber());
        }
        tripsRepository.save(tripsFromDb);
    }

    @Override
    public void deleteTrips(Long id) {
        tripsRepository.deleteById(id);
    }

    @Override
    public List<Trips> findAll() {
        return tripsRepository.findAll();
    }

    @Override
    public Trips findById(Long id) {
        Optional<Trips> trips = tripsRepository.findById(id);
        if(trips.isPresent()){
            return trips.get();
        }
        return null;
    }

    @Override
    public List<Trips> findByUserId(Long userId) {
        return tripsRepository.findByUserId(userId);
    }

    @Override
    public Trips findByDriverName(Long driverName) {
        return tripsRepository.findByDriverName(driverName);
    }

    @Override
    public Trips findByVehicleNumber(Long vehicleNumber) {
        return tripsRepository.findByVehicleNumber(vehicleNumber);
    }


}
