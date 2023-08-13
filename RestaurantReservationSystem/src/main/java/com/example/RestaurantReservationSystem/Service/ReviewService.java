package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.model.Restaurant;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    void addReview(Restaurant restaurant,  int rating);
}