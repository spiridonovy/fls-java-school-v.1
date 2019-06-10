package fls.alexKartFinal.services;

import fls.alexKartFinal.repos.*;
import fls.alexKartFinal.entities.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        List listPatients=patientRepository.findAll();
        return listPatients;
    }

    public Patient addPatient(Patient patient) {
        return  this.patientRepository.save(patient);
    }
}
