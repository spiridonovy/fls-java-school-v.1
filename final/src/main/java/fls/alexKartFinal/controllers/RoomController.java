package fls.alexKartFinal.controllers;

import fls.alexKartFinal.services.*;
import fls.alexKartFinal.entities.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;

    @GetMapping("/rooms")
    public List getAll()  {
        return roomService.getAllRooms();
    }

    @PostMapping("/rooms")
    public Room addRoom(@Valid @RequestBody Room room) {
        return roomService.addRoom(room);
    }
}
