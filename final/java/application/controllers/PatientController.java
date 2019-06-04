package application.controllers;

import application.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import application.services.PatientService;

import java.util.List;

@RestController
public class PatientController {

    public static final Logger logger= LoggerFactory.getLogger(PatientController.class);

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping(value = "/patients")
    public Patient addPatient(@RequestBody Patient patient){
        logger.info("Creating Patient: {}", patient);
        return patientService.addPatient(patient);
    }
}
