package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {


    Restaurant getRestaurantById(Long id);
      Restaurant addRestaurant(Restaurant restaurant);
    List<String> getAllRestaurantNames();
    List<Restaurant> getRestaurantsByCuisine(String cuisine);



  }