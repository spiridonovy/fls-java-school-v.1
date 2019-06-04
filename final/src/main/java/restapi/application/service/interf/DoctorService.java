package restapi.application.service.interf;

import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Doctor;

import java.util.List;

public interface DoctorService {
    List getAll() throws NoContentException;

    Doctor getDoctorById(Long id) throws ItemNotFoundException;

    Doctor addDoctor(Doctor doctor);
}
