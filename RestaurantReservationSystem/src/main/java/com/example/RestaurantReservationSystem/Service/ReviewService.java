package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.model.Restaurant;

public interface ReviewService {
    void addReview(Restaurant restaurant, int rating);
}