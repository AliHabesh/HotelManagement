package hotelmanagementapp;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HostelLogic {
    public static String sssn;



    public void setSsn(String ssn) {
        this.sssn = sssn;
    }

    public static String getSssn() {
        return sssn;
    }

    static ArrayList<Room> rooms = new ArrayList<>() {{
        add(new Room(1, 2, true, 20, false));
        add(new Room(2, 1, true, 15, false));
        add(new Room(3, 4, true, 30, true));
        add(new Room(4, 3, true, 25, true));
        add(new Room(5, 2, true, 20, true));
    }};
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    private static Scanner x;

    public void removeCustomer() {
        System.out.println("Enter the customer ssn: ");
        String ssn = input.nextLine();
        findCustomer(ssn);
        Customer customer1 = findCustomer(ssn);
        customers.remove(customer1);
    }

    public void removeRoom() {
        System.out.println("Enter the room number: ");
        int roomNbr = input.nextInt();
        findRoom(roomNbr);
        Room room1 = findRoom(roomNbr);
        rooms.remove(room1);
    }


    public Room getRoom(int roomNbr) {
        int x = 1;
        while (x == 1) {
            try {
                return rooms.get(roomNbr);
            } catch (Exception e) {
                System.out.println("Error!" + e.getMessage());
            }

        }

        return null;
    }

    public void getRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i));
        }
        if (rooms.isEmpty()) {
            System.out.println("No rooms exist!");
        }
    }

    public void getBookings() {
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println(bookings.get(i));
        }
        if (bookings.isEmpty()) {
            System.out.println("No rooms exist!");
        }
    }

    public void addCustomer() {
        String filepath = "C:\\Users\\Ali\\IdeaProjects\\Project_Course_2019_Group-12-\\src\\HotelManagementApplication\\Custom.txt";
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
                saveRecords(new Customer(ssn, name, address, phoneNumber), filepath);
                x = 2;
            } catch (Exception e) {
                System.out.println("There was an error, please keep in mind that you have to input with the correct format!" + e.getMessage());
            }
        } while (x == 1);
    }


    public void getCustomers() {

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
        if (customers.isEmpty()) {
            System.out.println("No customers available");
        }

    }

    public Customer getCustomer() throws FileNotFoundException {
        System.out.println("Enter the customers social security number");
        String ssn = input.nextLine();
        for (Customer customer : customers) {
            if (customer.getSsn().equals(ssn)) {
                return customer;
            }
        }
        readRecords(HostelLogic.sssn, "C:\\Users\\Ali\\IdeaProjects\\Project_Course_2019_Group-12-\\src\\HotelManagementApplication\\Custom.txt");

        return null;
    }

    public void printAvailableRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isBookingStatus()) {
                System.out.println(rooms.get(i));
            }
        }
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
        } while (x == 1);
    }

    public Room findRoom(int roomNumber) {
        Booking books = new Booking();
        for (Booking booking : bookings) {
            if (booking.room.getRoomNumber() == roomNumber) {

                books = booking;
            }
        }
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (room.isBookingStatus() == false) {
                    System.out.println("The room is not available until " + books.getCheckOutDate());
                } else if (room.isBookingStatus() == true) {
                    return room;
                }
            }
        }

        return null;
    }

    public Customer findCustomer(String ssn) {
        for (Customer customer : customers) {
            if ((customer.getSsn().equals(ssn))) {
                return customer;
            }
        }

        return null;
    }


    public void createBooking() throws ParseException {
        String filePath = "C:\\Users\\Ali\\IdeaProjects\\Project_Course_2019_Group-12-\\src\\HotelManagementApplication\\Booking.txt";
        int x = 1;
        while (x == 1) {
            try {
                Date CurrentDate = new Date();
                System.out.println("Enter the customer ssn: ");
                String ssn = input.nextLine();
                System.out.println(" ");
                System.out.println("Enter the customers name: ");
                String customerName = input.nextLine();
                System.out.println("Enter room number: ");
                int roomNumber = input.nextInt();
                input.nextLine();


                System.out.println("Enter the check in date in MM/dd/yyyy format");
                String CheckInDate = input.nextLine();
                Date UserInputDate = new SimpleDateFormat("MM/dd/yyyy").parse(CheckInDate);
                System.out.println("Enter the Date in MM/DD/YYYY format");
                String checkOutDate = input.nextLine();
                Date UserInputDate2 = new SimpleDateFormat("MM/dd/yyyy").parse(checkOutDate);

                Room room = findRoom(roomNumber);
                Customer customer = findCustomer(ssn);
                if (rooms.contains(room) && customers.contains(customer) && !UserInputDate.before(CurrentDate)) {
                    if (room.isBookingStatus() == true) {
                        room.setBookingStatus(false);
                    }
                    bookings.add(new Booking(UserInputDate, UserInputDate2, ssn, customer, room));
                    saveRecordsBooking(new Booking(UserInputDate, UserInputDate2, ssn, customer, room), filePath);

                    x = 2;
                } else {
                    System.out.println("There was an error, try again!");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("There was an error, please remember to input in the right format , Error was : " + e.getMessage());
            }
        }
    }


    public void editBooking() throws ParseException {
        System.out.println("enter customer ssn: ");
        String customerssn = input.nextLine();
        Booking currentBooking = new Booking();
        for (Booking booking1 : bookings) {
            if (booking1.getCustomerSnn().equals(customerssn)) {
                currentBooking = booking1;
            } else {
                System.out.println("No booking found with this ssn!");
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("----------------Edit----------------");
        System.out.println("1. Edit Customer social security number: ");
        System.out.println("2. Edit Customer Room number: ");
        System.out.println("3. Edit customer checkout Date: ");
        String choice = input.nextLine();


        switch (choice) {
            case "1":
                System.out.println("Enter the new ssn: ");
                String newssn = input.nextLine();
                currentBooking.setCustomerSnn(newssn);
                break;
            case "2":
                System.out.println("Enter the new room number: ");
                int roomNumber = input.nextInt();
                input.nextLine();
                currentBooking.room.setRoomNumber(roomNumber);
                break;
            case "3":
                System.out.println("Edit customer checkout Date, please enter the Date format in MM/dd/yyyy! ");
                String checkOutDate = input.nextLine();
                Date UserInputDate3 = new SimpleDateFormat("MM/dd/yyyy").parse(checkOutDate);
                currentBooking.setCheckOutDate(UserInputDate3);
                break;
            default:
                System.out.println("Error!");

        }
    }

    public ArrayList<Booking> showBookings() {
        return bookings;
    }


    public void createBooking2() throws ParseException { // New, update this to the class
        String filePath = "C:\\Users\\Ali\\IdeaProjects\\Project_Course_2019_Group-12-\\src\\HotelManagementApplication\\Booking.txt";
        try {
            Date CurrentDate = new Date();
            System.out.println("Enter your ssn: ");
            String customersnn = input.nextLine();
            input.nextLine();
            System.out.println("Enter the desired room number: ");
            int roomNumber = input.nextInt();
            System.out.println("Enter the check in Date in dd/mm/yyyy format");
            String CheckInDate = input.nextLine();
            Date UserInputDate = new SimpleDateFormat("dd/mm/yyyy").parse(CheckInDate);
            System.out.println("Enter the checkout Date in dd/mm/yyyy format");
            String checkOutDate = input.nextLine();
            Date UserInputDate2 = new SimpleDateFormat("dd/mm/yyyy").parse(CheckInDate);
            Room room = findRoom(roomNumber);
            Customer customer = findCustomer(customersnn);
            if (rooms.contains(room) && customers.contains(customer) && !UserInputDate.before(CurrentDate)) {
                if (room.isBookingStatus() == true) {
                    room.setBookingStatus(false);
                }
                bookings.add(new Booking(UserInputDate, UserInputDate2, customersnn, customer, room));
                saveRecordsBooking(new Booking(UserInputDate, UserInputDate2, customersnn, customer, room), filePath);
            }
        } catch (Exception e) {
            System.out.println("There was an error, please remember to input in the right format , Error was : " + e.getMessage());
        }

    }

    public Customer getCustomer2(String ssn) throws FileNotFoundException {
        for (Customer customer : customers) {
            if (customer.getSsn().equals(HostelLogic.sssn)) {
                return customer;
            }
        }

        readRecords(HostelLogic.sssn, "C:\\Users\\Ali\\IdeaProjects\\Project_Course_2019_Group-12-\\src\\HotelManagementApplication\\Custom.txt");
        return null;
    }

    public Booking getBooking() throws FileNotFoundException, ParseException {
        for (Booking booking : bookings) {
            if (booking.getCustomerSnn().equals(HostelLogic.sssn)) {
                return booking;
            }

        }

        readRecordsBooking(HostelLogic.sssn, "C:\\Users\\Ali\\IdeaProjects\\Project_Course_2019_Group-12-\\src\\HotelManagementApplication\\Booking.txt");
        return null;
    }

    public void editBookingCustomer(String ssn) throws ParseException {
        Booking currentBooking = new Booking();
        for (Booking booking1 : bookings) {
            if (booking1.getCustomerSnn().equals(ssn)) {
                currentBooking = booking1;
            } else {
                System.out.println("No booking found with this booking ssn!");
            }
        }

        System.out.println("----------------Edit----------------");
        System.out.println("1. Edit Customer social security number: ");
        System.out.println("2. Edit Customer Room number: ");
        System.out.println("3. Edit customer checkout Date: ");
        String choice = input.nextLine();


        switch (choice) {
            case "1":
                System.out.println("Enter the new ssn: ");
                String newssn = input.nextLine();
                input.nextLine();
                currentBooking.setCustomerSnn(newssn);
                break;
            case "2":
                System.out.println("Enter the new room number: ");
                int roomNumber = input.nextInt();
                input.nextLine();
                currentBooking.room.setRoomNumber(roomNumber);
                break;
            case "3":
                System.out.println("Edit customer checkout Date, please enter the Date format in dd/mm/yyyy! ");
                String checkOutDate = input.nextLine();
                Date UserInputDate3 = new SimpleDateFormat("dd/MM/yyyy").parse(checkOutDate);
                currentBooking.setCheckOutDate(UserInputDate3);
                break;
            default:
                System.out.println("Error!");

        }
    }

    public void saveRecords(Customer customer, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(customer);
            pw.flush();
            pw.close();

        } catch (Exception e) {
            System.out.println("Error, record not saved!" + e.getMessage());
        }
    }

    public void saveRecordsBooking(Booking booking, String filepath) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(booking);
            pw.flush();
            pw.close();

        } catch (Exception e) {
            System.out.println("Error, record not saved!" + e.getMessage());
        }

    }

    public static void readRecords(String searchTerm, String filePath) throws FileNotFoundException {
        boolean found = false;
        String ssn = "";
        String name = "";
        String address = "";
        String phoneNumber = "";
        try {


            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found) {
                ssn = x.next();
                name = x.next();
                address = x.next();
                phoneNumber = x.next();

                if (ssn.equals(searchTerm)) {
                    found = true;
                }

                if (found) {
                    System.out.println("Ssn: " + ssn + " name: " + name + " address: " + address + " phonenumber: " + phoneNumber);
                } else {
                    System.out.println("No customer found!");
                }
            }

        } catch (Exception e) {
            System.out.println("error!" + e.getMessage());

        }

    }


    public static void readRecordsBooking(String searchTerm, String filePath) throws FileNotFoundException, ParseException {
        boolean found = false;
        String customerSsn = "";
        String checkIN = new SimpleDateFormat("dd/mm/yyyy").format(new Date());
        String checkOut = new SimpleDateFormat("dd/mm/yyyy").format(new Date());
        String CustomerName = "";
        String roomNbr = "";
        try {

            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found) {
                customerSsn = x.next();
                checkIN = x.next();
                checkOut = x.next();
                roomNbr = x.next();

                if (customerSsn.equals(searchTerm)) {
                    found = true;
                }
                if (found) {
                    System.out.println("CustomerSsn:  " + customerSsn + "|| Check-in date: " + checkIN + "|| room number: " + roomNbr + "|| Check out: " + checkOut);
                } else {
                    System.out.println("No booking found!");
                }
            }

            }catch(Exception e){
            System.out.println("error!" + e.getMessage());


        }

    }
}







