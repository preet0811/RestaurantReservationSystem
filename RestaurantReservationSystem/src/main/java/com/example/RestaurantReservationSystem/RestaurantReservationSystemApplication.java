package com.example.RestaurantReservationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.RestaurantReservationSystem.repository")


public class RestaurantReservationSystemApplication {
		public static void main (String[]args){
			SpringApplication.run(RestaurantReservationSystemApplication.class, args);
		}

	}

