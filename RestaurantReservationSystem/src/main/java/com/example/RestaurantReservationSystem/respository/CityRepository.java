package com.example.RestaurantReservationSystem.respository;

import com.example.RestaurantReservationSystem.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {

}