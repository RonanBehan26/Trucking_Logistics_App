package com.trucking.logistics.dto;

import com.trucking.logistics.entites.Trips;
import com.trucking.logistics.entites.User;

import java.util.List;

public class UserAndTripsDTO {

    private User user;

    private List<Trips> trips;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Trips> getTrips() {
        return trips;
    }

    public void setTrips(List<Trips> trips) {
        this.trips = trips;
    }
}
