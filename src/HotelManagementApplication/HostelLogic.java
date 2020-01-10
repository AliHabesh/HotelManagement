package HotelManagementApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HostelLogic {
    static Scanner input = new Scanner(System.in);
  static  ArrayList<Room> rooms = new ArrayList<>() {{
      add(new Room(1, 2, true, 20, false));
      add(new Room(2, 1, true, 15, false));
      add(new Room(3, 4, true, 30, true));
      add(new Room(4, 3, true, 25, true));
      add(new Room(5, 2, true, 20, true));
  }};
  static ArrayList<Customer> customers = new ArrayList<>();
  static ArrayList<Booking> bookings = new ArrayList<>();


    public Room getRoom() {
        int roomNbr;
            System.out.println("Enter room number");
            roomNbr = input.nextInt();
            return rooms.get(roomNbr);
    }

    public ArrayList<Room> getRooms() {
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

    public void printAvailableRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isBookingStatus()) {
                System.out.println(rooms.get(i));
            }
        }
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


    public void editBooking(int bookingID) throws ParseException {

        Booking currentBooking = new Booking();
        for (Booking booking1: bookings) {
            if (booking1.getBookingId() == bookingID) {
                currentBooking = booking1;
            }else{
                System.out.println("No booking found with this booking id!");
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("----------------Edit----------------");
        System.out.println("1. Edit Customer social security number: ");
        System.out.println("2. Edit Customer Room number: ");
        System.out.println("3. Edit customer id");
        System.out.println("4. Edit customer checkout Date: ");
        int choice = input.nextInt();


        switch(choice) {
            case 1:
                System.out.println("Enter the new ssn: ");
                String newssn = input.nextLine();
                currentBooking.setCustomerSnn(newssn);

                break;
            case 2:
                System.out.println("Enter the new room number: ");
                int roomNumber = input.nextInt();
                currentBooking.room.setRoomNumber(roomNumber);

                break;
            case 3:
                System.out.println("Edit customer id");
                int bookingId = input.nextInt();
                currentBooking.setBookingId(bookingId);

                break;
            case 4:
                System.out.println("Edit customer checkout Date, please enter the Date format in dd/mm/yyyy! ");
                String checkOutDate = input.nextLine();
                Date UserInputDate3 = new SimpleDateFormat("dd/mm/yyyy").parse(checkOutDate);
                currentBooking.setCheckOutDate(UserInputDate3);

                break;
            default:
                System.out.println("Error!");

        }
    }


    public Room findRoom(int roomNumber) {
        for (Room room: rooms) {
        if (room.getRoomNumber()==roomNumber){
            return room; }
        }

        return null;
    }

    public Customer findCustomer(String customerName) {
        for (Customer customer: customers){
            if (customer.getName().equals(customerName)){
                return customer;
            }
        }
        return null;
    }

    public void removeCustomer(){
        int x = 1;
        do {
            try {
                System.out.println("Enter a number you wish to remove: ");
                int num =  input.nextInt();
                customers.remove(num);
                {

                    x=2;
                }
            } catch (Exception e){
                System.out.println("Please enter a valid number"+ e.getMessage());
            }

        }while (x ==1);


    }

    public void removeRooms() {
        int x = 1;
        do {
            try {
                System.out.println("!To exit press 3");
                System.out.println("Enter a number you wish to remove: ");
                int num = input.nextInt();
                rooms.remove(num);
                x = 2;
                x = 3;
            } catch (Exception e) {
                System.out.println("Please enter a valid number !" + e.getMessage());
            }
        } while (x == 1);

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

    public void addCustomer2() {                            // All the methods from here and below will be for customer Management.
        // The method names will always end with "2".
        int x = 1;
        do {
            try {
                System.out.println("Enter your Social Security Number: ");
                String ssn = input.nextLine();
                System.out.println("Enter your name: ");
                String name = input.nextLine();
                System.out.println("Enter your address: ");
                String address = input.nextLine();
                System.out.println("Enter your number: ");
                String phoneNumber = input.nextLine();
                customers.add(new Customer(ssn, name, address, phoneNumber));
                x = 2;
            } catch (Exception e) {
                System.out.println("There was an error, please keep in mind that you have to input with the correct format!");
            }
        } while (x == 1);
    }
    public void createBooking2() throws ParseException { // New, update this to the class
        try {
            System.out.println("Enter your name");
            String customerName = input.nextLine();
            input.nextLine();
            System.out.println("Enter the desired room number: ");
            int roomNumber = input.nextInt();
            input.nextLine();
            System.out.println("Enter the check in Date in dd/mm/yyyy format");
            String CheckInDate = input.nextLine();
            Date UserInputDate = new SimpleDateFormat("dd/mm/yyyy").parse(CheckInDate);
            System.out.println("Enter the checkout Date in dd/mm/yyyy format");
            String checkOutDate = input.nextLine();
            Date UserInputDate2 = new SimpleDateFormat("dd/mm/yyyy").parse(CheckInDate);
            Room room = findRoom(roomNumber);
            Customer customer = findCustomer(customerName);
            if (rooms.contains(room) && customers.contains(customerName)) {

                bookings.add(new Booking(UserInputDate, UserInputDate2, customer, room));
            }
        } catch (Exception e) {
            System.out.println("There was an error, please remember to input in the right format , Error was : " + e.getMessage());
        }
    }
    public void editBookingCustomer(int bookingID) throws ParseException {

        Booking currentBooking = new Booking();
        for (Booking booking1: bookings) {
            if (booking1.getBookingId() == bookingID) {
                currentBooking = booking1;
            }else{
                System.out.println("No booking found with this booking id!");
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("----------------Edit----------------");
        System.out.println("1. Edit Customer social security number: ");
        System.out.println("2. Edit Customer Room number: ");
        System.out.println("3. Edit customer checkout Date: ");
        int choice = input.nextInt();


        switch(choice) {
            case 1:
                System.out.println("Enter the new ssn: ");
                String newssn = input.nextLine();
                currentBooking.setCustomerSnn(newssn);

                break;
            case 2:
                System.out.println("Enter the new room number: ");
                int roomNumber = input.nextInt();
                currentBooking.room.setRoomNumber(roomNumber);

                break;
            case 3:
                System.out.println("Edit customer checkout Date, please enter the Date format in dd/mm/yyyy! ");
                String checkOutDate = input.nextLine();
                Date UserInputDate3 = new SimpleDateFormat("dd/mm/yyyy").parse(checkOutDate);
                currentBooking.setCheckOutDate(UserInputDate3);
                break;
            default:
                System.out.println("Error!");

        }
    }







}
