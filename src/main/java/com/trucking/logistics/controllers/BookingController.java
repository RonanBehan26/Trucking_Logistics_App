package com.trucking.logistics.controllers;

import com.trucking.logistics.entites.Booking;
import com.trucking.logistics.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")//works
    public Long createBooking(@Validated @RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/booking/{id}")//works
    public void updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
        bookingService.updateBooking(booking, id);
    }

    @DeleteMapping("/booking/{id}")//works
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @GetMapping("/booking")//works
    public List<Booking> getAllBookings() {
        return bookingService.findAllBookings();
    }

    @GetMapping("/booking/{id}")//works
    public Booking getBooking(@PathVariable("id") Long id) {
        return bookingService.findBookingById(id);
    }
}
