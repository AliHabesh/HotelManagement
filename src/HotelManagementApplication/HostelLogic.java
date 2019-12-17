package HotelManagementApplication;

import java.util.ArrayList;

public class HostelLogic {
  static  ArrayList<Room> rooms = new ArrayList<>();
  static ArrayList<Customer> customers = new ArrayList<>();


    public Room getRoom(int roomNbr) {
        return rooms.get(roomNbr);
    }

    public ArrayList<Room> getRooms() {
        rooms.add(new Room(1, 2,true, 20,true));
        rooms.add(new Room(1, 1,true, 15,true));
        rooms.add(new Room(1, 4,true, 30,true));
        rooms.add(new Room(1, 3,true, 25,true));
        rooms.add(new Room(1, 2,true, 20,true));
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

    public Customer getCustomer(String ssn) {
        for (int i = 0; i < customers.size(); i++) {
            for (Customer customer : customers) {
                if (customer.getSsn() == ssn) {
                    return customer;
                }
            }
        }
        return null;
    }
    public boolean addRoom(Room room) {
        return rooms.add(room);
    }




}
