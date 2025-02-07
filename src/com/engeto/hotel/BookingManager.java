package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private final List<Booking> bookingsList;

    public BookingManager(){
        this.bookingsList = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        bookingsList.add(booking);
    }

    public Booking getBooking(int index){
        bookingListIsEmpty();
        if (index >= 0 && index < bookingsList.size()) {
            return bookingsList.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid booking index");
    }

    public List<Booking> getBookings(){
        bookingListIsEmpty();
        return new ArrayList<>(bookingsList);
    }

    public void clearBookings(){
        bookingListIsEmpty();
        bookingsList.clear();
    }

    public int getNumberOfWorkingBookings(){
        bookingListIsEmpty();
        int count = 0;
        for (Booking booking : bookingsList){
            if (booking.getVacationType() == VacationType.WORK){
                count++;
            }
        }
        return count;
    }

    public void bookingListIsEmpty(){
        if (bookingsList.isEmpty()){
            System.out.println("Booking list is empty.");
        }
    }

    public double getAverageGuests(){
        bookingListIsEmpty();
        int totalGuests = 0;
        for (Booking booking : bookingsList){
            totalGuests += booking.getGuestsCount();
        }
        return (double) totalGuests / bookingsList.size();
    }

    public List<Booking> getTopNHolidayBookings(int n) {
        bookingListIsEmpty();
        List<Booking> holidayBookings = new ArrayList<>();
        for (Booking booking : holidayBookings){
            if (booking.getVacationType() == VacationType.RECREATION){
                holidayBookings.add(booking);
                if (holidayBookings.size() == n){
                    break;
                }
            }

        }
        return holidayBookings;
    }

    public void printGuestStatistics(){
        bookingListIsEmpty();
        int oneGuest = 0;
        int twoGuests = 0;
        int moreGuests = 0;
        for (Booking booking : bookingsList){
            int guestCount = booking.getGuestsCount();
            if (guestCount == 1){
                oneGuest++;
            } else if (guestCount == 2) {
                twoGuests++;
            } else {
                moreGuests++;
            }
        }
        System.out.println("Total bookings with one guest: " + oneGuest);
        System.out.println("Total bookings with two guests: " + twoGuests);
        System.out.println("Total bookings with more than two guests: " + moreGuests);
    }

    public void printFormattedSummaries() {
        for (Booking booking : bookingsList) {
            System.out.println(booking.getFormattedSummary());
        }
    }
}
