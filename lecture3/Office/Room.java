package Office;

import Person.Emploee;

import java.util.ArrayList;

public class Room {
    private String roomName;
    private ArrayList<Emploee> emploeesInRoom;

    public Room(String roomNumber) {
        this.roomName = roomNumber;
        this.emploeesInRoom = new ArrayList<Emploee>();
    }

    public Room(String roomNumber, ArrayList<Emploee> emploeesInRoom) {
        this.roomName = roomNumber;
        this.emploeesInRoom = emploeesInRoom;
    }

    public String getRoomName() {
        return roomName;
    }
}
