package restapi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapi.application.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
