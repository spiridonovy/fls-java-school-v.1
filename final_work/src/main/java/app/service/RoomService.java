package app.service;

import app.entity.Room;
import app.exception.NoEntityException;

import java.util.List;

public interface RoomService {

    Room update(Long id, Room room) throws NoEntityException;

    Room add(Room room);

    Room getById(Long id) throws NoEntityException;

    List getAll();

    void delete(Long id);
}
