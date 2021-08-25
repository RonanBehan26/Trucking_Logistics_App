package com.trucking.logistics.services;

import com.trucking.logistics.entites.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    
    Long createBooking(Booking booking);

    void updateBooking(Booking booking, Long id);

    void deleteBooking(Long id);

    List<Booking> findAllBookings();

    Booking findBookingById(Long id);

    List<Booking> findBookingUserId(Long id);
}
