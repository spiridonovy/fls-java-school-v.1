package com.flslecturefinalalpinx.Controllers;

import com.flslecturefinalalpinx.Exceptions.NoContentException;
import com.flslecturefinalalpinx.Models.Room;
import com.flslecturefinalalpinx.Repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class RoomController {

    private IRoomRepository roomRepository;

    @Autowired
    public RoomController(IRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/room/{id}")
    @ResponseBody
    public Room FindById(@PathVariable int id)
    {
        var room = roomRepository.findById(id);
        if (room == null) throw new NoContentException();
        return room;
    }

    @PostMapping("/room")
    @ResponseBody
    public Room Create(@RequestBody() String name)
    {
        return roomRepository.save(new Room(name));
    }

    @GetMapping("/room")
    @ResponseBody
    public ArrayList<Room> FindByName(@RequestParam(name = "name") String name)
    {
        var room = roomRepository.findByName(name);
        if (room == null||room.isEmpty()) throw new NoContentException();
        return room;
    }
}