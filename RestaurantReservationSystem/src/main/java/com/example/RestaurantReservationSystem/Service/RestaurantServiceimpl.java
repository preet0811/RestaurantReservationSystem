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
        return null;
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return null;
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

}
