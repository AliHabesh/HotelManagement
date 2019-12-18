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
            System.out.println("10. Exit");
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
                    System.out.println(myApp.getAvailableRooms());
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
                case 9:
                    System.out.println(myApp.showBookings()+"\n");
                    break;
                case 10:
                    x = 2;
                    break;






            }
        }
    }

}
