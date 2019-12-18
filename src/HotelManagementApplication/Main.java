package HotelManagementApplication;

import com.sun.source.tree.AssignmentTree;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        HotelMenu myApp = new HotelMenu();
        myApp.MenuApp();
    }
    }

