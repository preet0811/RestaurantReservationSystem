package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.respository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CityServiceImpl implements CityService{
    private final CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;

    }
    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }


    @Override
    public City createCity(City city) {
        return cityRepository.save(city);
    }




}