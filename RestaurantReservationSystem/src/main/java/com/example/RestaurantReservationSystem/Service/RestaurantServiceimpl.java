package com.example.RestaurantReservationSystem.Service;
import com.example.RestaurantReservationSystem.Service.RestaurantService;
import com.example.RestaurantReservationSystem.exception.NotEnoughSeatsException;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;
import com.example.RestaurantReservationSystem.model.Review;
import com.example.RestaurantReservationSystem.respository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class RestaurantServiceimpl implements RestaurantService {
    @Autowired
    private final RestaurantRepository restaurantRepository;

      public RestaurantServiceimpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(City city) {
        return restaurantRepository.findByCity(city);
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> getTopRatedRestaurants() {
        return restaurantRepository.findAllByOrderByAverageRatingDesc();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void reserveSeats(Long restaurantId, int numSeats) throws NotEnoughSeatsException {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found with ID: " + restaurantId);
        }

        if (restaurant.getAvailableSeats() >= numSeats) {
            int remainingSeats = restaurant.getAvailableSeats() - numSeats;
            restaurant.setAvailableSeats(remainingSeats);
            restaurantRepository.save(restaurant);
        } else {
            throw new NotEnoughSeatsException("Not enough available seats to reserve.");
        }
    }

    @Override
    public void giveReview(Long restaurantId, String reviewText, int rating) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found with ID: " + restaurantId);
        }

        Review review = new Review();
        review.setRestaurant(restaurant);
        review.setReviewText(reviewText);
        review.setRating(rating);

        // Calculate new average rating
        double currentAverageRating = restaurant.getAverageRating();
        int numReviews = restaurant.getReviews().size();
        double newAverageRating = ((currentAverageRating * numReviews) + rating) / (numReviews + 1);
        restaurant.setAverageRating(newAverageRating);

        restaurantRepository.save(restaurant);
    }
}
