package com.engeto.hotel;

import java.math.BigDecimal;

public class Room {
    private final int roomNumber;
    private final int numberOfBeds;
    private final boolean hasBalcony;
    private final boolean hasSeaView;
    private final BigDecimal pricePerNight;

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean hasSeaView, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasSeaView = hasSeaView;
        this.pricePerNight = pricePerNight;
    }

    public Room(int roomNumber, BigDecimal pricePerNight) {
        this(roomNumber, 2, false, false, pricePerNight); // Default capacity = 2, no balcony, no sea view
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }
}
