package com.engeto.hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private Room room;
    private Guest guest;
    private Date startDate;
    private Date endDate;
    private String vacationType;

    public Booking(Room room, Guest guest, Date startDate, Date endDate, String vacationType) {
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }

    public void displayBookingInfo(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");
        System.out.println("Booking details: ");
        System.out.println("Guest: " + guest.getFullName());
        System.out.println("Room number: " + room.getRoomNumber());
        System.out.println("Stay period: from " + simpleDateFormat.format(startDate) + " to " + simpleDateFormat.format(endDate));
        System.out.println("Vacation type: " + vacationType);
        System.out.println();
    }
}
