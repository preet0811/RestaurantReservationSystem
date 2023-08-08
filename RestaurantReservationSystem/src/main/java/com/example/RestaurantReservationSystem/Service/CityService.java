package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City getCityById(Long id);

    City createCity(City city);
}