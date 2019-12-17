package HotelManagementApplication;

import java.util.ArrayList;
import java.util.Date;
public class Booking {

    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private ArrayList<Room> room;
    private String customerSnn;

    public Booking(int bookingId, Date checkOutDate, double totalPrice, ArrayList<Room> room) { // continue this once HotelLogic class is done
        this.bookingId = bookingId;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.room = room;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Room> getRoom() {
        return room;
    }

    public void setRoom(ArrayList<Room> room) {
        this.room = room;
    }

    public String getCustomerSnn() {
        return customerSnn;
    }

    public void setCustomerSnn(String customerSnn) {
        this.customerSnn = customerSnn;
    }
}





