package HotelManagementApplication;

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

<<<<<<< HEAD


=======
>>>>>>> 6f3323b6471c0cf40c121571bb1c65d5aee6df3b
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


    public boolean editBooking(String ssn, Booking booking) {
        if(booking.getCustomerSnn()==null){
            booking.setCustomerSnn(ssn);
            return true;
        }
        return false;
    }

    public void addRoom() {

        int x = 1;
        do {
            try {
                System.out.println("Enter the desired number of the new room: ");
                int roomNumber = input.nextInt();
                System.out.println("Enter number of beds: ");
                int numberOfBeds = input.nextInt();
                System.out.println("Will the room have balcony? y/n");
                boolean balcony = input.nextBoolean();
                System.out.println("What is the price per night?");
                double pricePerNight = input.nextDouble();
                System.out.println("will the room be available or not?");
                boolean reply = input.nextBoolean();
                rooms.add(new Room(roomNumber, numberOfBeds, balcony, pricePerNight, reply));
                x = 2;
            } catch (Exception e) {
                System.out.println("There was an error, please keep in mind to input the correct format!");
            }
        }while (x == 1);
    }





}
