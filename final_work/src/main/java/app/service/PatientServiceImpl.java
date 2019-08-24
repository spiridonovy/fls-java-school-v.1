package app.service;

import app.entity.Patient;
import app.exception.NoEntityException;
import app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository repository;

    @Override
    public Patient update(Long id, Patient newPatient) throws NoEntityException {
        Patient oldPatient = repository.findById(id)
                .map(patient -> {
                    patient.setName(newPatient.getName());
                    patient.setSex(newPatient.getSex());
                    patient.setDayOfBirth(newPatient.getDayOfBirth());
                    return repository.save(patient);
                }).orElseGet(() -> {
                    newPatient.setId(id);
                    return repository.save(newPatient);
                });
        return oldPatient;
    }

    @Override
    public Patient add(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient getById(Long id) throws NoEntityException {
        return repository.findById(id)
                .orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
