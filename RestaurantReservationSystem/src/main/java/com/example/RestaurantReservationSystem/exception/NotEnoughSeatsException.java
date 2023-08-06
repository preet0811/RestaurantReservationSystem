package com.example.RestaurantReservationSystem.exception;

public class NotEnoughSeatsException extends RuntimeException {
    public NotEnoughSeatsException() {
        super();
    }

    public NotEnoughSeatsException(String message) {
        super(message);
    }

    public NotEnoughSeatsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughSeatsException(Throwable cause) {
        super(cause);
    }
}

