package com.flslecturefinalalpinx.Controllers;

import com.flslecturefinalalpinx.Exceptions.NoContentException;
import com.flslecturefinalalpinx.Models.Patient;
import com.flslecturefinalalpinx.Models.Requests.PatientRequest;
import com.flslecturefinalalpinx.Repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PatientController {
    private IPatientRepository patientRepository;

    @Autowired
    public PatientController(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient/{id}")
    @ResponseBody
    public Patient FindById(@PathVariable int id) {
        var patient = patientRepository.findById(id);
        if (patient == null) throw new NoContentException();
        return patient;
    }

    @GetMapping("/patient/findAll")
    @ResponseBody
    public ArrayList<Patient> FindAll() {
        var patient = patientRepository.findAll();
        if (patient == null || patient.isEmpty()) throw new NoContentException();
        return patient;
    }

    @PostMapping("/patient")
    @ResponseBody
    public Patient Create(@RequestBody() PatientRequest request) {
        return patientRepository.save(new Patient(request.name, request.dayofbirth, request.sex));
    }

    @GetMapping("/patient")
    @ResponseBody
    public ArrayList<Patient> FindByName(@RequestParam(name = "name") String name) {
        var patients = patientRepository.findByName(name);
        if (patients == null) throw new NoContentException();
        return patients;
    }
}
