package app.service;

import app.entity.Room;
import app.exception.NoEntityException;
import app.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;

    @Override
    public Room update(Long id, Room newRoom) throws NoEntityException {
        Room oldRoom = repository.findById(id).map(room -> {
            room.setName(newRoom.getName());
            return repository.save(room);
        }).orElseGet(()-> {
            newRoom.setId(id);
            return repository.save(newRoom);
        });
        return oldRoom;
    }

    @Override
    public Room add(Room room) {
        return repository.save(room);
    }

    @Override
    public Room getById(Long id) throws NoEntityException {
        return repository.findById(id).
                orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
