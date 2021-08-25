package com.trucking.logistics.dto;

import com.trucking.logistics.entites.Booking;
import com.trucking.logistics.entites.User;

import java.util.List;

public class UserAndBookingDTO {

    private User user;

    private List<Booking> booking;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
