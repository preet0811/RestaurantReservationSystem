package com.example.RestaurantReservationSystem.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurant_id;

    @Column(nullable = false)
    private String restaurant_name;

    @Column(nullable = false)
    private String cuisine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false) // Use @JoinColumn instead of @Column
    private City city;  // Many-to-One association with City entity

    @Column(nullable = false)
    private double Rating;

    @Column(nullable = false)
    private int waitTime;

    @Column(nullable = false)
    private int availableSeats;

    @Column(nullable = false)
    private boolean active = true;
    public void setActive(boolean active) {
        this.active = active;
    }

}