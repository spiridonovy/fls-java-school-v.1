package app.service;

import app.entity.Patient;
import app.exception.NoEntityException;

import java.util.List;

public interface PatientService {

    Patient update(Long id, Patient doctor) throws NoEntityException;

    Patient add(Patient doctor);

    Patient getById(Long id) throws NoEntityException;

    List getAll();

    void delete(Long id);
}
