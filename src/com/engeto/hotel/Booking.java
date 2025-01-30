package com.engeto.hotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Booking {
    private Room room;
    private List<Guest> guests;
    private Date startDate;
    private Date endDate;
    private String vacationType;

    public Booking(Room room, List<Guest> guests, Date startDate, Date endDate, String vacationType) {
        this.room = room;
        this.guests = guests;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }

    public void displayBookingInfo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d. M. yyyy");
        System.out.println("Booking Details:");
        String guestNames = guests.stream()
                .map(Guest::getFullName)
                .collect(Collectors.joining(", "));
        System.out.println("Guests: " + guestNames);
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Stay Period: " + simpleDateFormat.format(startDate) + " to " + simpleDateFormat.format(endDate));
        System.out.println("Vacation Type: " + vacationType + "\n");
    }

    public boolean isGuestBooked(Guest guest) {
        return guests.contains(guest);
    }

    public boolean isRoomAvailable(Date start, Date end) {
        return end.before(startDate) || start.after(endDate);
    }

    public boolean isGuestInBooking(Guest guest) {
        return guests.contains(guest);
    }
}
