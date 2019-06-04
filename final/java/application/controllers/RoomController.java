package application.controllers;

import application.models.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import application.services.RoomService;

import java.util.List;

@RestController
public class RoomController {
    public static final Logger logger= LoggerFactory.getLogger(RoomController.class);

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List getAllRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping("/rooms")
    public Room addRoom(Room room){
        logger.info("Creating Room : {}", room);
        return roomService.addRoom(room);
    }
}
