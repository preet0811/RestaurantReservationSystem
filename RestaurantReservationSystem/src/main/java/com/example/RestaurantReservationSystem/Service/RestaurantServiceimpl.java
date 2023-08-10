package com.example.RestaurantReservationSystem.Service;
import com.example.RestaurantReservationSystem.model.Restaurant;
import com.example.RestaurantReservationSystem.respository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}