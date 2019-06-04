package application.services;

import application.models.Room;

import java.util.List;

public interface RoomService {
    List getAllRooms();

    Room addRoom(Room room);
}
