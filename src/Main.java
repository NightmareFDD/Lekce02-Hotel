import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Jan", "Novák", "17.12.1992");
        Room room101 = new Room(101, 1, false, false, new BigDecimal(2500.00));
        Booking booking1 = new Booking(room101, guest1, "20.04.2025", "05.05.2025", "Working stay");

        Guest guest2 = new Guest("Lucie", "Marešová", "15.03.1989");
        Room room201 = new Room(201, 2, true, true, new BigDecimal(3500.00));
        Booking booking2 = new Booking(room201, guest2, "22.07.2025", "29.07.2025", "Recreation");

        booking1.displayBookingInfo();
        booking2.displayBookingInfo();
    }
}
