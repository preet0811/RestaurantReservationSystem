package com.example.RestaurantReservationSystem.model;
import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurant_name;

    @Column(nullable = false)
    private String cuisine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false) // Use @JoinColumn instead of @Column
    private City city;  // Many-to-One association with City entity


}