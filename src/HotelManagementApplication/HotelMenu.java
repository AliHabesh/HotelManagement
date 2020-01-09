package HotelManagementApplication;

import java.text.ParseException;
import java.util.Scanner;

public class HotelMenu {

    public void MenuApp() throws ParseException {
        HostelLogic myApp = new HostelLogic();
        Scanner input = new Scanner(System.in);

        int x = 1;
        while (x == 1) {
            System.out.println("-----------------Menu------------");
            System.out.println("1. add customer");
            System.out.println("2. Show all customers");
            System.out.println("3. Show specific customer");
            System.out.println("4. get all available rooms ");
            System.out.println("5. Add rooms");
            System.out.println("6. Show all rooms");
            System.out.println("7. Add a booking");
            System.out.println("8. Edit booking");
            System.out.println("9. Show all bookings");
            System.out.println("10. Remove customer");
            System.out.println("11. Remove room");
            System.out.println("12. Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    myApp.addCustomer();
                    break;
                case 2:
                    System.out.println(myApp.getCustomers());
                    break;
                case 3:
                    System.out.println(myApp.getCustomer());
                    break;
                case 4:
                    myApp.getAvailableRooms();
                    break;
                case 5:
                    myApp.addRoom();
                    break;
                case 6:
                    System.out.println(myApp.getRooms()+"\n");
                    break;
                case 7:
                    myApp.createBooking();
                    break;
                case 8:
                    System.out.println("Enter bookingId: ");
                    int bookingId = input.nextInt();
                    myApp.editBooking(bookingId);
                case 9:
                    System.out.println(myApp.showBookings());
                    break;
                case 10:
                    myApp.removeCustomer();
                    break;
                case 11:
                    myApp.removeRooms();
                    break;
                case 12: 
                    x = 2;
                    break;






            }
        }
    }

    public void customerMenu() throws ParseException {
        HostelLogic myApp = new HostelLogic();
        Scanner input = new Scanner(System.in);
        int choice;
        int x = 1;
        while (x == 1) {
            System.out.println("--------------");
            System.out.println("1. Create your profile");
            System.out.println("2. Edit your profile");
            System.out.println("3. Check available rooms");
            System.out.println("4. Add a booking");
            System.out.println("5. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    myApp.addCustomer2();
                    break;
                case 2:
                    System.out.println("Enter booking id");
                    int bookingID = input.nextInt();
                    myApp.editBookingCustomer(bookingID);
                    break;
                case 3:
                    myApp.getAvailableRooms();
                    break;
                case 4:
                    myApp.createBooking2();
                case 5:
                    x = 2;

            }
        }
    }

}
