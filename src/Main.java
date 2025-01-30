import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;
import com.engeto.hotel.VacationType;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Guests
        Guest guest1 = new Guest("Adéla", "Malíková", simpleDateFormat.parse("1993-03-13"));
        Guest guest2 = new Guest("Jan", "Dvořáček", simpleDateFormat.parse("1995-05-05"));
        guest2.setBirthDate(simpleDateFormat.parse("1995-04-05"));
        System.out.println(guest2.getFullName() + " (" + guest2.getFormattedBirthDate() + ")");
        System.out.println();

        // Rooms
        Room room1 = new Room(1, 1, true, true, new BigDecimal(1000));
        Room room2 = new Room(2, 1, true, true, new BigDecimal(1000));
        Room room3 = new Room(3, 3, false, true, new BigDecimal(2400));

        // Bookings
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(room1, List.of(guest1), simpleDateFormat.parse("2021-07-19"), simpleDateFormat.parse("2021-07-26"), VacationType.RECREATION));
        bookings.add(new Booking(room3, List.of(guest1,guest2), simpleDateFormat.parse("2021-09-01"), simpleDateFormat.parse("2021-09-14"), VacationType.RECREATION));

        for (Booking booking : bookings){
            booking.displayBookingInfo();
        }
    }
}
