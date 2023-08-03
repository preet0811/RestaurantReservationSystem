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
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


    @Column(nullable = false)
    private String cuisine;

    @Column(nullable = false)
    private double averageRating;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews = new ArrayList<>();

    @Column(nullable = false)
    private List<String> popularDishes = new ArrayList<>();

    @Column(nullable = false)
    private int waitTimeInMinutes;

    @Column(nullable = false)
    private int totalSeats;

    @Column(nullable = false)
    private int availableSeats;

    // Getters, setters, and constructors
}

