package restapi.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Room;
import restapi.application.repository.RoomRepository;
import restapi.application.service.interf.RoomService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    final private RoomRepository roomRepository;

    @Override
    public List getAll() throws NoContentException {
        List list = roomRepository.findAll();
        if (list.isEmpty()) throw new NoContentException();
        return list;
    }

    @Override
    public Room getRoomById(Long id) throws ItemNotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
}
