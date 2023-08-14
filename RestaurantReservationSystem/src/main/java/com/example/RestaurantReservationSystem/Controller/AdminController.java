package com.example.RestaurantReservationSystem.Controller;

import com.example.RestaurantReservationSystem.Service.CityService;
//import com.example.RestaurantReservationSystem.Service.RestaurantService;
import com.example.RestaurantReservationSystem.Service.RestaurantService;
import com.example.RestaurantReservationSystem.exception.RestaurantNotFoundException;
import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.model.Restaurant;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/admins")
public class AdminController<cuisine, CuisineResponse> {
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/cities")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = cityService.createCity(city);
        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(restaurant);
        }
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<String>> getAllRestaurantNames() {
        List<String> restaurantNames = restaurantService.getAllRestaurantNames();
        return ResponseEntity.ok(restaurantNames);
    }

    @RequestMapping("/restaurants")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.addRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    @GetMapping("/cuisines/{cuisine}")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCuisine(@PathVariable String cuisine) {
        // Logic to get restaurants by cuisine
        List<Restaurant> restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        return ResponseEntity.ok(restaurants);
    }

    @DeleteMapping("restaurants/{restaurantId}")
    public ResponseEntity<String> deactivateRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deactivateRestaurant(restaurantId);
        return ResponseEntity.ok("Restaurant deactivated successfully.");
    }

    @DeleteMapping("restaurants/delete/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deleterestaurant(restaurantId);
        return ResponseEntity.ok("Restaurant deleted successfully.");
    }

    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Restaurant> modifyRestaurantDetails(
            @PathVariable Long restaurantId,
            @RequestBody Restaurant restaurant
    ) {
        // Implementation of the method
        Restaurant existingRestaurant = restaurantService.getRestaurantById(restaurantId);
        if (existingRestaurant == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the existing restaurant details
        existingRestaurant.setRestaurant_name(restaurant.getRestaurant_name());
        existingRestaurant.setCuisine(restaurant.getCuisine());
        existingRestaurant.setRating(restaurant.getRating());
        existingRestaurant.setAvailableSeats(restaurant.getAvailableSeats());
        existingRestaurant.setWaitTime(restaurant.getWaitTime());
        // Update other attributes as needed

        Restaurant modifiedRestaurant = restaurantService.addRestaurant(existingRestaurant);
        return ResponseEntity.ok(modifiedRestaurant);
    }


}