package com.Tomato.exception;

public class DifferentRestaurentException extends TomatoException {
    public DifferentRestaurentException(String currrestaurant, String newRestaurant) {
        super("Cannot order from a different restaurant. Current: " + currrestaurant + ", Attempted: " + newRestaurant);
    }
}
