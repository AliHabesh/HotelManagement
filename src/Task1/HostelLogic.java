package Task1;

import java.util.ArrayList;

public class HostelLogic {
    ArrayList<Room> rooms = new ArrayList<>();


    public Room getRoom(int roomNbr) {
        return rooms.get(roomNbr);
    }

    public ArrayList<Room> getRooms() {
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
}
