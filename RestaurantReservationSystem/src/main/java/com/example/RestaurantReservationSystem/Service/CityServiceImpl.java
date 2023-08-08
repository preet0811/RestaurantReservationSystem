package com.example.RestaurantReservationSystem.Service;

import com.example.RestaurantReservationSystem.model.City;
import com.example.RestaurantReservationSystem.respository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CityServiceImpl implements CityService{
    private CityRepository cityRespository;
    public CityServiceImpl(CityRepository cityRespository){
        this.cityRespository=cityRespository;
    }
    @Override
    public List<City> getAllCities() {
        return cityRespository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRespository.findById(id).orElse(null);
    }

    @Override
    public City createCity(City city) {
        return cityRespository.save(city);
    }
}