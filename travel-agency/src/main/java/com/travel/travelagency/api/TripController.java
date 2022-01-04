package com.travel.travelagency.api;

import com.travel.travelagency.repo.model.Trip;
import com.travel.travelagency.service.TripService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trips")
public final class TripController {

    private final TripService tripService;

    //List of Trips
    @GetMapping
    public ResponseEntity<List<Trip>> index(){
        final List<Trip> trips = tripService.fetchAll();
        return ResponseEntity.ok(trips);
    }
    //Get trip by id
    @GetMapping("/{id}")
    public ResponseEntity<Trip> show(@PathVariable long id){
        try {
            final Trip trip = tripService.fetchById(id);
            return ResponseEntity.ok(trip);
        } catch (IllegalArgumentException e) {
            // 404 error
            return ResponseEntity.notFound().build();
        }
    }

    //create new trip
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.travel.travelagency.api.dto.Trip trip){
        final String country = trip.getCountry();
        final String city = trip.getCity();
        final String description = trip.getDescription();
        final Integer price = trip.getPrice();
        final long id = tripService.create(country,city,description,price);
        final String location = String.format("/trips/" + id);

        return ResponseEntity.created(URI.create(location)).build();
        // 201 status code created() URI location - location resours'a kotoriy sozdadim
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.travel.travelagency.api.dto.Trip trip){
        // return  ResponseEntity.ok().build();
        final String country = trip.getCountry();
        final String city = trip.getCity();
        final String description = trip.getDescription();
        final Integer price = trip.getPrice();

        try {
            tripService.update(id,country,city,description,price);
            return ResponseEntity.noContent().build();
        }catch(IllegalArgumentException e){
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        tripService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
