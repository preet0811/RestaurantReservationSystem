package com.example.RestaurantReservationSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Restaurant restaurant;

    @Column(nullable = false)
    private String reviewText;

    @Column(nullable = false)
    private int rating; // Rating out of 5 stars

    public Review() {
    }

    // Constructor to deserialize JSON data
    public Review(String reviewText, int rating) {
        this.reviewText = reviewText;
        this.rating = rating;
    }
    // Getters, setters, and constructors
}

