package com.travel.travelagency.repo;

import com.travel.travelagency.repo.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepo extends JpaRepository<Trip, Long> {

}
