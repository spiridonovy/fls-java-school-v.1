package fls.fin.api;

import fls.fin.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
    Optional<Study> findById(Long id);

    ArrayList<Study> findByName(String name);

    ArrayList<Study> findAll();
}
