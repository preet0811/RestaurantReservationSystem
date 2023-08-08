package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.exception.NotEnoughSeatsException;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantById(Long id);

    Restaurant addRestaurant(Restaurant restaurant);


    List<String> getAllRestaurantNames();
}