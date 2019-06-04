package fls.fin.api;

import fls.fin.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findById(Long id);

    Optional<Room> findByName(String name);

    ArrayList<Room> findAll();
}
