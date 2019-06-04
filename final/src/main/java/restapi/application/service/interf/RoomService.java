package restapi.application.service.interf;

import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Room;

import java.util.List;

public interface RoomService {
    List getAll() throws NoContentException;

    Room getRoomById(Long id) throws ItemNotFoundException;

    Room addRoom(Room room);
}
