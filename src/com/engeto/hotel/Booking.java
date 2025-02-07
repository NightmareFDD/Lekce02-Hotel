package com.engeto.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;


public class Booking {
    private final Room room;
    private final List<Guest> guests;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final VacationType vacationType;

    public Booking(Room room, List<Guest> guests, LocalDate startDate, LocalDate endDate, VacationType vacationType) {
        validateGuests(guests);
        this.room = room;
        this.guests = new ArrayList<>(guests);
        this.startDate = determineStartDate(startDate);
        this.endDate = determineEndDate(this.startDate, endDate);
        this.vacationType = vacationType;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public int getGuestsCount() {
        return guests.size();
    }

    public long getBookingLength() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public BigDecimal getTotalPrice() {
        return room.getPricePerNight().multiply(BigDecimal.valueOf(getBookingLength()));
    }

    private static void validateGuests(List<Guest> guests) {
        if (guests == null || guests.isEmpty()) {
            throw new IllegalArgumentException("A booking must have at least one guest.");
        }
    }

    private static LocalDate determineStartDate(LocalDate startDate) {
        return (startDate == null) ? LocalDate.now() : startDate;
    }

    private static LocalDate determineEndDate(LocalDate startDate, LocalDate endDate) {
        return (endDate == null) ? startDate.plusDays(6) : endDate;
    }

    public String getFormattedSummary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. M. yyyy");
        String guestNames = guests.stream()
                .map(Guest::getFullName)
                .collect(Collectors.joining(", "));
        return String.format("%s až %s: %s [%d] za %s Kč",
                startDate.format(formatter),
                endDate.format(formatter),
                guestNames,
                guests.size(),
                getTotalPrice().toPlainString());
    }

    public void displayBookingInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. M. yyyy");
        System.out.println("Booking Details:");
        String guestNames = guests.stream()
                .map(Guest::getFullName)
                .collect(Collectors.joining(", "));
        System.out.println("Guests: " + guestNames);
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Stay Period: " + startDate.format(formatter) + " to " + endDate.format(formatter));
        System.out.println("Vacation Type: " + vacationType + "\n");
    }
}

