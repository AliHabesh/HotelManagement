    package HotelManagementApplication;

import java.util.Date;
public class Booking {

    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    Room room;
    private String customerSnn;
    private Customer customer;

    public Booking(int bookingId, Date checkInDate,Date checkOutDate ,Customer customer, Room room) { // continue this once HotelLogic class is done
        this.bookingId = bookingId;
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalPrice=" + totalPrice +
                ", room=" + room +
                ", customerSnn='" + customerSnn + '\'' +
                ", customer=" + customer +
                '}';
    }

    public Booking(Date checkInDate, Date checkOutDate, Customer customer, Room room) { // Customer Management, create booking.
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.room = room;
        this.checkOutDate = checkOutDate;
    }
    public Booking() {

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



    public String getCustomerSnn() {
        return customerSnn;
    }

    public void setCustomerSnn(String customerSnn) {
        this.customerSnn = customerSnn;
    }
}






