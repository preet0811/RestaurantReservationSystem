package com.example.RestaurantReservationSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String city_name;

    public City(){}
    public City(String name) {
        this.city_name = name;
    }

    // Getters, setters, and constructors
}