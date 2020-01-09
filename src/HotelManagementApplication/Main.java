package HotelManagementApplication;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        HotelMenu myApp = new HotelMenu();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your mail: ");
        String mail = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        if (mail.toLowerCase().endsWith("@employee.com")) {
            myApp.MenuApp();
        }else{
            myApp.customerMenu();
        }

    }
}

