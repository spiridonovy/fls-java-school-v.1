package fls.fin.api;

import fls.fin.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByName(String name);

    Optional<Patient> findById(Long id);

    ArrayList<Patient> findAll();
}
