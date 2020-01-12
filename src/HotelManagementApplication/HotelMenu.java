package HotelManagementApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class HotelMenu {

    public void customerMenu() throws ParseException, FileNotFoundException {
        HostelLogic myApp = new HostelLogic();
        Scanner input = new Scanner(System.in);
        int choice;
        boolean x = true;
        while (x) {
            System.out.println("--------------");
            System.out.println("1. Edit your profile");
            System.out.println("2. Check available rooms");
            System.out.println("3. Add a booking");
            System.out.println("4. Get your customer information");
            System.out.println("5. Exit/Log out");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter booking ID");
                    String ssn = input.nextLine();
                    myApp.editBookingCustomer(ssn);
                    break;
                case 2:
                    myApp.printAvailableRooms();
                    break;
                case 3:
                    myApp.createBooking2();
                    break;
                case 4:
                    myApp.getCustomer2(HostelLogic.sssn);
                    break;
                case 5:
                    x = false;
                    break;
                default:
                    System.out.println("Error");


            }
        }
    }

    public void empMenu() throws ParseException, IOException {
        HostelLogic myApp = new HostelLogic();
        Scanner input = new Scanner(System.in);
        boolean y = true;
        while (y) {
            System.out.println("---------------------------");
            System.out.println("1. add customer");
            System.out.println("2. Show all customers");
            System.out.println("3. Show specific customer");
            System.out.println("4. get all available rooms ");
            System.out.println("5. Add rooms");
            System.out.println("6. Add a room");
            System.out.println("7. Add a booking");
            System.out.println("8. Edit booking");
            System.out.println("9. Show all bookings");
            System.out.println("10. Remove a room");
            System.out.println("11. Remove a customer");
            System.out.println("12. Exit");
            System.out.println("-----------------------------");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    myApp.addCustomer();
                    break;
                case 2:
                    myApp.getCustomers();
                    break;
                case 3:
                    System.out.println(myApp.getCustomer());
                    break;
                case 4:
                    myApp.printAvailableRooms();
                    break;
                case 5:
                    myApp.addRoom();
                    break;
                case 6:
                    myApp.getRooms();
                    break;
                case 7:
                    myApp.createBooking();
                    break;
                case 8:
                    System.out.println("Enter the booking id: ");
                    String ssn = input.nextLine();
                    myApp.editBooking(ssn);
                case 9:
                    System.out.println(myApp.showBookings());
                    break;
                case 10:
                    myApp.removeRoom();
                    break;
                case 11:
                    myApp.removeCustomer();
                    break;
                case 12:
                    y = false;
                    break;






            }
        }

    }

}
