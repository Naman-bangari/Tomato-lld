package com.Tomato.models;

import java.time.Instant;
import java.util.UUID;

public class Address {
 private final String id;
    private final String label;
    private final String street;
    private final String city;
    private final String pincode;
    private final Location location;
    private boolean isDefault;
    private Instant lastUsedAt;

    public Address(String label, String street, String city, String pincode, Location location) {
        this(UUID.randomUUID().toString(), label, street, city, pincode, location);
    }

    private Address(String id, String label, String street, String city,
                    String pincode, Location location) {
        if (pincode == null || pincode.isBlank()) throw new IllegalArgumentException("pincode required");
        if (location == null) throw new IllegalArgumentException("location required");
        this.id = id;
        this.label = label;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.location = location;
    }

    public Address snapshot() {
        return new Address(id, label, street, city, pincode, location);
    }

    public void markUsed() { this.lastUsedAt = Instant.now(); }

    void setDefault(boolean value) { this.isDefault = value; }

    public String getId() { return id; }
    public String getLabel() { return label; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPincode() { return pincode; }
    public Location getLocation() { return location; }
    public boolean isDefault() { return isDefault; }
    public Instant getLastUsedAt() { return lastUsedAt; }

    @Override
    public String toString() {
        return label + " (" + street + ", " + city + " " + pincode + ")";
    }
}