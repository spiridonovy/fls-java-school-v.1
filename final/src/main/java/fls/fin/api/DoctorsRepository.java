package fls.fin.api;

import fls.fin.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface DoctorsRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findById(Long id);

    Optional<Doctor> findByName(String name);

    ArrayList<Doctor> findAll();
}
