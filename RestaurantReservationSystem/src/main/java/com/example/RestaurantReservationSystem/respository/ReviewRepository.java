package com.example.RestaurantReservationSystem.respository;

import com.example.RestaurantReservationSystem.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}