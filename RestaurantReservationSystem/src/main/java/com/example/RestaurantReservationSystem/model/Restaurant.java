package com.example.RestaurantReservationSystem.model;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cuisine;
    private double averageRating;
    private int waitTime;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantDetails> detailsList;

    // Getters and setters, constructors, and other methods
}
