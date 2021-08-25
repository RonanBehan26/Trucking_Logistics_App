package com.trucking.logistics.controllers;

import com.trucking.logistics.entites.Trips;
import com.trucking.logistics.services.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    private TripsService tripsService;

    @PostMapping("/tripsAction")//works
    public Long createTrips(@Validated @RequestBody Trips trips) {
        return tripsService.createTrips(trips);
    }

    @PutMapping("/tripsAction/{id}")//works
    public void updateTrips(@RequestBody Trips trips, @PathVariable Long id) {
        tripsService.updateTrips(trips, id);
    }

    @DeleteMapping("/tripsAction/{id}")//works
    public void deleteTrips(@PathVariable Long id) {
        tripsService.deleteTrips(id);
    }

    @GetMapping("/tripsAction")//works
    public List<Trips> getAllTrips() {
        return tripsService.findAll();
    }

    @GetMapping("/tripsAction/{id}")//works
    public Trips getTrips(@PathVariable("id") Long id) {
        return tripsService.findById(id);
    }
}
