package com.example.RestaurantReservationSystem.Controller;

import com.example.RestaurantReservationSystem.Service.CityService;
//import com.example.RestaurantReservationSystem.Service.RestaurantService;
import com.example.RestaurantReservationSystem.Service.RestaurantService;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final CityService cityService;
    private final RestaurantService restaurantService;

    public AdminController(CityService cityService, RestaurantService restaurantService) {
        this.cityService = cityService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/cities/{cityId}")
    public ResponseEntity<City> getCityById(@PathVariable Long cityId) {
        City city = cityService.getCityById(cityId);
        if (city != null) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        }
    }

    @RequestMapping("/cities")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.createCity(city);
        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    }

    @RequestMapping("/restaurants")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurant> modifyRestaurantDetails(
            @PathVariable Long restaurantId,
            @RequestBody Restaurant restaurant
    ) {
        // Check if the restaurant with the given ID exists
        Restaurant existingRestaurant = restaurantService.getRestaurantById(restaurantId);
        if (existingRestaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the restaurant details
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setCuisine(restaurant.getCuisine());
        existingRestaurant.setPopularDishes(restaurant.getPopularDishes());
        existingRestaurant.setWaitTimeInMinutes(restaurant.getWaitTimeInMinutes());
        existingRestaurant.setTotalSeats(restaurant.getTotalSeats());
        existingRestaurant.setAvailableSeats(restaurant.getAvailableSeats());

        Restaurant updatedRestaurant = restaurantService.addRestaurant(existingRestaurant);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<String> deactivateRestaurant(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant != null) {
            // Deactivate the restaurant by setting its available seats to 0
            restaurant.setAvailableSeats(0);
            restaurantService.addRestaurant(restaurant);
            return new ResponseEntity<>("Restaurant deactivated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Restaurant not found.", HttpStatus.NOT_FOUND);
        }
    }
}



