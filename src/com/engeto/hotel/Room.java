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

    public int getRoomNumber() {
        return roomNumber;
    }

}
