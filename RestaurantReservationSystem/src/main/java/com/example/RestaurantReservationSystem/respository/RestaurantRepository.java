package com.example.RestaurantReservationSystem.respository;

import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query("SELECT r.name FROM Restaurant r")
    List<String> getAllRestaurantNames();

    List<Restaurant> findByCuisine(String cuisine);

}