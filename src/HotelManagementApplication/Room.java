package HotelManagementApplication;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean balcony;
    private double pricePerNight;
    private boolean bookingStatus;
    private Customer customer;

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", numberOfBeds=" + numberOfBeds +
                ", balcony=" + balcony +
                ", pricePerNight=" + pricePerNight +
                ", bookingStatus=" + bookingStatus +
                '}';
    }

    public Room(int roomNumber, int numberOfBeds, boolean balcony, double pricePerNight, boolean bookingStatus) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.balcony = balcony;
        this.pricePerNight = pricePerNight;
        this.bookingStatus = bookingStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(boolean bookingStatus) {
            this.bookingStatus = bookingStatus;

    }



}
