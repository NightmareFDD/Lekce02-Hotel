import com.engeto.hotel.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        fillBookings(bookingManager);
        bookingManager.printFormattedSummaries();
    }

    public static void fillBookings(BookingManager bookingManager) {
        // Guests
        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest guest3 = new Guest("Karolina", "Tma", LocalDate.of(1985, 7, 12));
        Guest guest4 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 1, 1));  // Partner from first booking

        // Rooms
        Room room2 = new Room(2, new BigDecimal("1500.0"));
        Room room3 = new Room(3, new BigDecimal("2000.0"));

        // Bookings
        bookingManager.addBooking(new Booking(room3, List.of(guest1), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), VacationType.WORK));
        bookingManager.addBooking(new Booking(room2, List.of(guest2), LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), VacationType.RECREATION));
        bookingManager.addBooking(new Booking(room3, List.of(guest3, guest4), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), VacationType.WORK));

        // 10 recurring bookings in August
        LocalDate startDate = LocalDate.of(2023, 8, 1);
        for (int i = 0; i < 10; i++) {
            bookingManager.addBooking(new Booking(room2, List.of(guest3), startDate, startDate.plusDays(2), VacationType.RECREATION));
            startDate = startDate.plusDays(2);
        }
    }
}

