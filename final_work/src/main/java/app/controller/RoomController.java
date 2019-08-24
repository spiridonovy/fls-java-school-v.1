package app.controller;

import app.entity.Room;
import app.exception.NoEntityException;
import app.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService service;

    @Autowired
    public RoomController(RoomService service){
        this.service = service;
    }

    @GetMapping("/all")
    public List getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Room getById(@PathVariable(value = "id") Long id) throws NoEntityException {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable Long id, @RequestBody String name) throws NoEntityException {
        return service.update(id, new Room(name));
    }

    @PostMapping("/new")
    public Room add(@RequestBody String name) {
        return service.add(new Room(name));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
