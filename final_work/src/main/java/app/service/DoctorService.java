package app.service;

import app.entity.Doctor;
import app.exception.NoEntityException;

import java.util.List;

public interface DoctorService  {

    Doctor update(Long id, Doctor doctor) throws NoEntityException;

    Doctor add(Doctor doctor);

    Doctor getById(Long id) throws NoEntityException;

    List getAll();

    void delete(Long id);
}
