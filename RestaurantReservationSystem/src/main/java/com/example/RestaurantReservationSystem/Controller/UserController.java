package com.example.RestaurantReservationSystem.Controller;

import com.example.RestaurantReservationSystem.Service.CityService;
import com.example.RestaurantReservationSystem.Service.RestaurantService;
import com.example.RestaurantReservationSystem.Service.ReviewService;
import com.example.RestaurantReservationSystem.exception.NotEnoughSeatsException;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;
import com.example.RestaurantReservationSystem.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;
    private final CityService cityService;

    public UserController(RestaurantService restaurantService, ReviewService reviewService, CityService cityService) {
        this.restaurantService = restaurantService;
        this.reviewService = reviewService;
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        if (cities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cities);
    }
    @GetMapping("/cities/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable Long cityId) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<String>> getAllRestaurantNames() {
        List<String> restaurantNames = restaurantService.getAllRestaurantNames();
        return ResponseEntity.ok(restaurantNames);
    }



    @GetMapping("restaurants/cuisines/{cuisine}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCuisine(@PathVariable String cuisine) {
        // Logic to get restaurants by cuisine
        List<Restaurant> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/cities/restaurants/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurant);
    }

    //--------------------------------------------------------------------------------------//


    @GetMapping("/restaurants/wait-time/{waitTime}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByWaitTime(@PathVariable int waitTime) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByWaitTime(waitTime);
        if (restaurants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/restaurants/available-seats/{availableSeats}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByAvailableSeats(@PathVariable int availableSeats) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByAvailableSeats(availableSeats);
        if (restaurants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restaurants);
    }
}