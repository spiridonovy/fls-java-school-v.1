package fls.fin.controllers;

import fls.fin.api.RoomRepository;
import fls.fin.entity.Room;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class RoomController {
    private RoomRepository repo;

    @GetMapping("/rooms/{id}")
    @ResponseBody
    public Room findById(@PathVariable Long id) {
        try {
            Optional<Room> room = repo.findById(id);
            return room.get();
        } catch (Exception e) {
            System.out.println("Could not get the room by id");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/rooms")
    @ResponseBody
    public Room findByName(@RequestParam String name) {
        try {
            Optional<Room> room = repo.findByName(name);
            return room.get();
        } catch (Exception e) {
            System.out.println("Could not get the room by name");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/rooms")
    @ResponseBody
    public ArrayList<Room> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Could not get rooms");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @PostMapping("/rooms")
    @ResponseBody
    public Room saveRoom(@RequestBody Room room) {
        return repo.save(room);
    }

    @PostMapping("/rooms")
    @ResponseBody
    public Room updateRoom(@RequestBody Room room) {
        return repo.save(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping("/rooms")
    public void delete(@RequestBody Room room) {
        repo.delete(room);
    }
}
