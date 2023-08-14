package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.exception.RestaurantNotFoundException;
import com.example.RestaurantReservationSystem.model.Restaurant;
import com.example.RestaurantReservationSystem.model.Review;
import com.example.RestaurantReservationSystem.respository.RestaurantRepository;
import com.example.RestaurantReservationSystem.respository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceimpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewServiceimpl(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void addReview(Restaurant restaurant, int rating) {
        Review review = new Review();
        review.setRestaurant(restaurant);
        review.setRating(rating);
        reviewRepository.save(review);
    }


    // Implement other methods for rating restaurants, etc.
}