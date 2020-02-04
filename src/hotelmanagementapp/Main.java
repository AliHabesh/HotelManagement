package hotelmanagementapp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        HotelMenu myApp = new HotelMenu();
        Scanner input = new Scanner(System.in);
        boolean x = true;
        while (x) {
            System.out.println("Enter your mail: ");
            String mail = input.nextLine();
            System.out.println("Enter your password: ");
            String password = input.nextLine();

            if (mail.toLowerCase().endsWith("ali@employee.com") && password.equals("12345")) {
                myApp.empMenu();
                x = false;
            }else if (mail.toLowerCase().endsWith("bright@employee.com") && password.equals("12345")){
                myApp.empMenu();
                x = false;
            }else if (mail.equals("ali@stud.hkr.se") && password.equals("12345")) {
                HostelLogic.sssn = "19971029";
                myApp.customerMenu();
                x = false;
            }else if (mail.equals("makel@stud.hkr.se") && password.equals("12345")){
                HostelLogic.sssn = "19940701";
                myApp.customerMenu();
                x=false;
            }
            else if(mail.equals("clara@email.com") && password.equals("12345")){
                HostelLogic.sssn = "19950101";
                myApp.customerMenu();
            }else if (mail.equals("Admin")&& password.equals("12345")){

                myApp.adminMenu();

            }
            else{
                System.out.println("Wrong email or password");
            }
        }

    }
}

