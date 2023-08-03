package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.exception.NotEnoughSeatsException;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getRestaurantsByCity(City city);

    List<Restaurant> getRestaurantsByCuisine(String cuisine);

    List<Restaurant> getTopRatedRestaurants();

    Restaurant getRestaurantById(Long id);

    Restaurant addRestaurant(Restaurant restaurant);

    void reserveSeats(Long restaurantId, int numSeats) throws NotEnoughSeatsException;

    void giveReview(Long restaurantId, String reviewText, int rating);
}
