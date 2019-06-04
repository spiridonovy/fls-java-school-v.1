package application.services;

import application.models.Patient;


import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient addPatient(Patient patient);
}
