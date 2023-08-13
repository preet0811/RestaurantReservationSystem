package com.example.RestaurantReservationSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rating; // Rating out of 5 stars

    public void setRestaurant(Restaurant restaurant) {
    }

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "review_id", nullable = false) // Use @JoinColumn instead of @Column
//    private Restaurant restaurant;
}