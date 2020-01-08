package HotelManagementApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HostelLogic {
    static Scanner input = new Scanner(System.in);
  static  ArrayList<Room> rooms = new ArrayList<>();
  static ArrayList<Customer> customers = new ArrayList<>();
  static ArrayList<Booking> bookings = new ArrayList<>();


    public Room getRoom() {
        int roomNbr;
            System.out.println("Enter room number");
            roomNbr = input.nextInt();
            return rooms.get(roomNbr);
    }

    public ArrayList<Room> getRooms() {
        rooms.add(new Room(1, 2,true, 20,false));
        rooms.add(new Room(2, 1,true, 15,false));
        rooms.add(new Room(3, 4,true, 30,false));
        rooms.add(new Room(4, 3,true, 25,true));
        rooms.add(new Room(5, 2,true, 20,true));
        return rooms;
     }

     public ArrayList<Room> getAvailableRooms() {
        ArrayList availableRooms = new ArrayList<>();
         for (int i = 0; i < rooms.size(); i++) {
             if (rooms.get(i).isBookingStatus()){
                 availableRooms.add(i);
             }
         }
         return availableRooms;
     }


    public Customer getCustomer() {
        String ssn;
        System.out.println("Input Customer ssn");
        ssn = input.nextLine();
        for (Customer customer : customers) {
                if (customer.getSsn().equals(ssn)) {
                    return customer;
                }
            }
        return null;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean editBooking(Booking booking) {
        String ssn = "";
        System.out.println("----------------Edit----------------");
        System.out.println("1. Edit Customer social security number: ");
        System.out.println("2. Edit Customer Room number: ");
        System.out.println("3. Edit customer id: ");
        System.out.println("4. Edit customer Date: ");

        if(booking.getCustomerSnn()==null){
            booking.setCustomerSnn(ssn);
            return true;
        }
        return false;
    }


    public Room findRoom(int roomNumber) {
        int index;
        if((index = rooms.indexOf(roomNumber)) > 0)
            return rooms.get(index);
        return null;
    }

    public Customer findCustomer(String customerName) {
        int index;
        if ((index = customers.indexOf(customerName)) > 0) {
            return customers.get(index);
        }
        return null;
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

    public ArrayList<Booking> showBookings() {
        return bookings;
    }

    public void addCustomer() {
        int x = 1;
        do {
            try {
                System.out.println("Enter the Social Security Number: ");
                String ssn = input.nextLine();
                System.out.println("Enter the name of the person: ");
                String name = input.nextLine();
                System.out.println("Enter the address of the person: ");
                String address = input.nextLine();
                System.out.println("Enter the phone number: ");
                String phoneNumber = input.nextLine();
                customers.add(new Customer(ssn, name, address, phoneNumber));
                x = 2;
            } catch (Exception e) {
                System.out.println("There was an error, please keep in mind that you have to input with the correct format!");
            }
        }while (x == 1);
    }



    public void createBooking() throws ParseException {
        try {
            System.out.println("Enter the customers name");
            String customerName = input.nextLine();
            System.out.println("Enter room number: ");
            int roomNumber = input.nextInt();
            input.nextLine();
            System.out.println("Enter the Date in dd/mm/yyyy format");
            String date = input.nextLine();
            Date UserInputDate = new SimpleDateFormat("dd/mm/yyyy").parse(date);
            System.out.println("Enter the Customer Id: ");
            int customerId = input.nextInt();
            Room room = findRoom(roomNumber);
            Customer customer = findCustomer(customerName);
            if (rooms.contains(room) && customers.contains(customerName)) {

                bookings.add(new Booking(customerId, UserInputDate, customer, room));
            }
        }catch (Exception e) {
            System.out.println("There was an error, please remember to input in the right format , Error was : "+e.getMessage());
        }

    }








}
