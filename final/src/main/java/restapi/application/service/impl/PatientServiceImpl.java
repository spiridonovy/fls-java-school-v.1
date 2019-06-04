package restapi.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Patient;
import restapi.application.repository.PatientRepository;
import restapi.application.service.interf.PatientService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    final private PatientRepository patientRepository;

    @Override
    public List getAll() throws NoContentException {
        List list = patientRepository.findAll();
        if (list.isEmpty()) throw new NoContentException();
        return list;
    }

    @Override
    public Patient getPatientById(Long id) throws ItemNotFoundException {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
