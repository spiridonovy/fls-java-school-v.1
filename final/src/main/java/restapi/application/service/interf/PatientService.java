package restapi.application.service.interf;

import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Patient;

import java.util.List;

public interface PatientService {
    List getAll() throws NoContentException;

    Patient getPatientById(Long id) throws ItemNotFoundException;

    Patient addPatient(Patient patient);
}
