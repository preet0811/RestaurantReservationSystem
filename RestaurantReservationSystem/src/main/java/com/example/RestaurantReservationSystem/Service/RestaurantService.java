package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.exception.RestaurantNotFoundException;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {


    Restaurant getRestaurantById(Long id);
    Restaurant addRestaurant(Restaurant restaurant);
    List<String> getAllRestaurantNames();
    List<Restaurant> getRestaurantsByCuisine(String cuisine);
    void deactivateRestaurant(Long restaurantId);
    void deleterestaurant(Long restaurantId);
    Restaurant modifyRestaurantDetails(Long restaurantId, Restaurant modifiedRestaurant) throws RestaurantNotFoundException;
    List<Restaurant> getRestaurantsByWaitTime(int waitTime);

    List<Restaurant> getRestaurantsByAvailableSeats(int availableSeats);

}