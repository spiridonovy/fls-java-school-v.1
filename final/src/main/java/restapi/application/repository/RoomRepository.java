package restapi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.application.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
