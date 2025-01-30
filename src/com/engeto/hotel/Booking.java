package com.engeto.hotel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Booking {
    private final Room room;
    private final List<Guest> guests;
    private final Date startDate;
    private final Date endDate;
    private final VacationType vacationType;

    public Booking(Room room, List<Guest> guests, Date startDate, Date endDate, VacationType vacationType) {
        validateGuests(guests);
        this.room = room;
        this.guests = new ArrayList<>(guests);

        this.startDate = determineStartDate(startDate);
        this.endDate = determineEndDate(startDate, endDate);

        this.vacationType = vacationType;
    }

    private static void validateGuests(List<Guest> guests) {
        if (guests == null || guests.isEmpty()) {
            throw new IllegalArgumentException("A booking must have at least one guest.");
        }
    }

    private static Date determineStartDate(Date startDate) {
        return (startDate == null) ? Calendar.getInstance().getTime() : startDate;
    }

    private static Date determineEndDate(Date startDate, Date endDate) {
        if (endDate == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((startDate == null) ? calendar.getTime() : startDate);
            calendar.add(Calendar.DAY_OF_MONTH, 6);
            return calendar.getTime();
        }
        return endDate;
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
}
