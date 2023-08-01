package com.example.RestaurantReservationSystem.Controller;

import com.example.RestaurantReservationSystem.Service.CityService;
import com.example.RestaurantReservationSystem.Service.RestaurantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final CityService cityService;
    private final RestaurantService restaurantService;

    public AdminController(CityService cityService, RestaurantService restaurantService) {
        this.cityService = cityService;
        this.restaurantService = restaurantService;
    }

    // Implement REST endpoints for admin-specific functionalities
    // Such as creating a new city, adding a new restaurant, etc.
}
