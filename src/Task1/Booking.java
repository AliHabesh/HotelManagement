package Task1;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    public Booking(int bookingId, Date checkOutDate, double totalPrice) { // continue this once HotelLogic class is done
        this.bookingId = bookingId;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
    }


}
