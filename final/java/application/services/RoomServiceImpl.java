package application.services;

import application.models.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.RoomRepository;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    public static final Logger logger=LoggerFactory.getLogger(RoomServiceImpl.class);

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List getAllRooms() {
        logger.debug("Returning list of all the rooms.");
        return roomRepository.findAll();
    }

    @Override
    public Room addRoom(Room room) {
        return null;
    }
}
