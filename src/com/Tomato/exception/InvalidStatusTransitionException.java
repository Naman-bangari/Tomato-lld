package com.Tomato.exception;

public class InvalidStatusTransitionException extends TomatoException {
    
    public InvalidStatusTransitionException(String currentStatus, String newStatus) {
        super("Invalid status transition from " + currentStatus + " to " + newStatus);
    }
}
