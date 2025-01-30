package com.engeto.hotel;

public class Booking {
    private Room room;
    private Guest guest;
    private String startDate;
    private String endDate;
    private String vacationType;

    public Booking(Room room, Guest guest, String startDate, String endDate, String vacationType) {
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }

    public void displayBookingInfo(){
        System.out.println("Booking details: ");
        System.out.println("Guest: " + guest.getFullName());
        System.out.println("Room number: " + room.getRoomNumber());
        System.out.println("Stay period: from " + startDate + " to " + endDate);
        System.out.println("Vacation type: " + vacationType);
        System.out.println();
    }
}
