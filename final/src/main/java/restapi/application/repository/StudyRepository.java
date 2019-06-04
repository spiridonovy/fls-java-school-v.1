package restapi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.application.model.Study;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
}
