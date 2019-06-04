package application.services;

import application.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    public static final Logger logger= LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        logger.debug("Returning list of all the patients.");
        List listPatients=patientRepository.findAll();
        return listPatients;
    }

    @Override
    public Patient addPatient(Patient patient) {
        logger.info("Add patient with values {}.",patient);
        return  this.patientRepository.save(patient);
    }
}
