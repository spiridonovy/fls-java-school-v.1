package restapi.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Patient;
import restapi.application.service.interf.PatientService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public List getAll() throws NoContentException {
        return patientService.getAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable(value = "id") Long patientId) throws ItemNotFoundException {
        return patientService.getPatientById(patientId);
    }

    @PostMapping("/patients")
    public Patient addPatient(@Valid @RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }
}
