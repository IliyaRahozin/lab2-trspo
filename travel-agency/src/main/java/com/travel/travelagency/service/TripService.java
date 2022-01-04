package com.travel.travelagency.service;

import com.travel.travelagency.repo.TripRepo;
import com.travel.travelagency.repo.model.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class TripService {

    private final TripRepo tripRepo;
    // All trips from Database
    public List<Trip> fetchAll() {
        return tripRepo.findAll();
    }

    // Find by id
    public Trip fetchById(long id) throws IllegalArgumentException  {
        final Optional<Trip> maybeTrip = tripRepo.findById(id);

        if (maybeTrip.isEmpty()) throw new IllegalArgumentException("Trip not found");
        else return maybeTrip.get();
        //throw new RuntimeException("Unimplemented");
    }

    // Return created id instance
    public long create(String country, String city, String description, Integer price) {
        final Trip trip = new Trip(country,city,description,price);
        final Trip savedTrip = tripRepo.save(trip);
        return savedTrip.getId();
        //throw new RuntimeException("Unimplemented");
    }

    // Update instance
    public void update(long id,String country, String city, String description, Integer price) throws IllegalArgumentException {
        final Optional<Trip> maybeTrip = tripRepo.findById(id);
        if (maybeTrip.isEmpty()) throw new IllegalArgumentException("Trip not found");

        final Trip trip = maybeTrip.get();
        if (country != null && !country.isBlank()) trip.setCounty(country);
        if (city != null && !city.isBlank()) trip.setCity(city);
        if (description != null && !description.isBlank()) trip.setDescription(description);
        if (price != null && !price.equals(0)) trip.setDescription(description);
        tripRepo.save(trip);

        //throw new RuntimeException("Unimplemented");
    }

    // Delete instance
    public void delete(long id) {
        tripRepo.deleteById(id);
        //throw new RuntimeException("Unimplemented");
    }
}
