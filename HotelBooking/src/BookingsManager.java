

import java.util.HashMap;

public class BookingsManager {

    public static class Booking {
        private String customerName;
        private String idNumber;
        private int days;
        private String roomType;

        public Booking(String customerName, String idNumber, int days, String roomType) {
            this.customerName = customerName;
            this.idNumber = idNumber;
            this.days = days;
            this.roomType = roomType;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public int getDays() {
            return days;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    private static final HashMap<Integer, String> rooms = new HashMap();
    private static final HashMap<Integer, Booking> bookings = new HashMap();

    static {
        rooms.put(101, "Single");
        rooms.put(102, "Single");
        rooms.put(201, "Double");
        rooms.put(202, "Double");
        rooms.put(301, "Suite");
        rooms.put(302, "Suite");
    }

    public static HashMap<Integer, Booking> getBookingsMap() {
        return bookings;
    }

    public static int bookRoom(String roomType, Booking booking) {
        for (Integer roomNumber : rooms.keySet()) {
            if (rooms.get(roomNumber).equals(roomType) && !bookings.containsKey(roomNumber)) {
                bookings.put(roomNumber, booking);
                return roomNumber;
            }
        }
        return -1;
    }

    public static HashMap<Integer, Booking> getAllBookings() {
        return bookings;
    }
}