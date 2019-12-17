package Task1;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class HostelLogic {
    static Scanner input = new Scanner(System.in);
  static  ArrayList<Room> rooms = new ArrayList<>();
  static ArrayList<Customer> customers = new ArrayList<>();


    public Room getRoom() {
        int roomNbr;
            System.out.println("Enter room number");
            roomNbr = input.nextInt();
            System.out.println("Error");
            return rooms.get(roomNbr);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
     }

     public ArrayList<Room> getAvailableRooms() {
        ArrayList availableRooms = new ArrayList<>();
         for (int i = 0; i < rooms.size(); i++) {
             if (rooms.get(i).isBookingStatus()== true){
                 availableRooms.add(i);
             }
         }
         return availableRooms;
     }
     public void addRoom() {
         System.out.println("Enter a room Number: ");
         int roomnbr = input.nextInt();
     }

    public Customer getCustomer() {
        String ssn;
        System.out.println("Input Customer ssn");
        ssn = input.nextLine();
        for (Customer customer : customers) {
                if (customer.getSsn() == ssn) {
                    return customer;
                }
            }
        return null;
    }

    public void editBooking(String ssn, Booking booking) {
        if(booking.getCustomerSnn()==null){
            booking.setCustomerSnn(ssn);
            return true;
        }
        return false;
    }



}
