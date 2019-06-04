package restapi.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Room;
import restapi.application.service.interf.RoomService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/rooms")
    public List getAll() throws NoContentException {
        return roomService.getAll();
    }

    @GetMapping("/rooms/{id}")
    public Room getRoomById(@PathVariable(value = "id") Long roomId) throws ItemNotFoundException {
        return roomService.getRoomById(roomId);
    }

    @PostMapping("/rooms")
    public Room addRoom(@Valid @RequestBody Room room) {
        return roomService.addRoom(room);
    }
}