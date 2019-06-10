package fls.alexKartFinal.services;

import fls.alexKartFinal.repos.*;
import fls.alexKartFinal.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List getAllRooms() {
        return roomRepository.findAll();
    }

    public Room addRoom(Room room) {
        return  this.roomRepository.save(room);
    }
}
