package com.example.RestaurantReservationSystem.Service;
import com.example.RestaurantReservationSystem.exception.RestaurantNotFoundException;
import com.example.RestaurantReservationSystem.model.Restaurant;
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
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }


    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<String> getAllRestaurantNames() {
        return restaurantRepository.getAllRestaurantNames();
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    @Override
    public void deactivateRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow();

        restaurant.setActive(false);
        restaurantRepository.save(restaurant);
    }

    @Override
    public void deleterestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public Restaurant modifyRestaurantDetails(Long restaurantId, Restaurant modifiedRestaurant) throws RestaurantNotFoundException {
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with ID " + restaurantId + " not found."));

        existingRestaurant.setRestaurant_name(modifiedRestaurant.getRestaurant_name());
        existingRestaurant.setCuisine(modifiedRestaurant.getCuisine());
        existingRestaurant.setRating(modifiedRestaurant.getRating());
        // Update other attributes as needed

        return restaurantRepository.save(existingRestaurant);
    }
    @Override
    public List<Restaurant> getRestaurantsByWaitTime(int waitTime) {
        return restaurantRepository.findByWaitTimeLessThan(waitTime);
    }

    @Override
    public List<Restaurant> getRestaurantsByAvailableSeats(int availableSeats) {
        return restaurantRepository.findByAvailableSeatsGreaterThanEqual(availableSeats);
    }






}