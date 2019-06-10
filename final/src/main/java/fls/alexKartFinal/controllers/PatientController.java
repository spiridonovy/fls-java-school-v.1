package fls.alexKartFinal.controllers;

import org.springframework.web.bind.annotation.*;
import fls.alexKartFinal.services.*;
import fls.alexKartFinal.entities.*;
import java.util.List;
import javax.validation.Valid;

@RestController
public class PatientController {

    private PatientService patientService;

    @GetMapping("/patients")
    public List getAll() {
        return patientService.getAllPatients();
    }

    @PostMapping("/patients")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }
}
