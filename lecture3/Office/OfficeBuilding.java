package Office;

import java.util.ArrayList;

public class OfficeBuilding {
    private String officeName;
    private ArrayList<Room> officeRooms;

    public OfficeBuilding(String officeName,ArrayList<Room> officeRooms){
        this.officeName = officeName;
        this.officeRooms=officeRooms;
    }

    public String getOfficeName() {
        return officeName;
    }

    public ArrayList<Room> getOfficeRooms() {
        return officeRooms;
    }
    public Room getOfficeRoomByName(String roomName) {
        for (var room : this.officeRooms) {
            if (room.getRoomName() == roomName)
                return room;
        }
        return null;
    }
}
