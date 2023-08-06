package com.example.RestaurantReservationSystem.respository;

import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
//
List<Restaurant> findByCity(City city);
    List<Restaurant> findByCuisine(String cuisine);
    List<Restaurant> findAllByOrderByAverageRatingDesc();
}
