package Task1;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean balcony;
    private double pricePerNight;
    private boolean bookingStatus;

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
}
