package com.Tomato.enums;

public enum DeliveryStatus {
    SEARCHING,
    ASSIGNED,
    AT_RESTAURANT,
    PICKED_UP,
    DELIVERED,
    FAILED;
    
    public boolean toTransition(DeliveryStatus newStatus) {

        return switch (this) {
            case SEARCHING -> newStatus == ASSIGNED || newStatus == FAILED;
            case ASSIGNED -> newStatus == AT_RESTAURANT || newStatus == FAILED;
            case AT_RESTAURANT -> newStatus == PICKED_UP || newStatus == FAILED;
            case PICKED_UP -> newStatus == DELIVERED || newStatus == FAILED;
            case DELIVERED, FAILED -> false;
        };
    }
}
