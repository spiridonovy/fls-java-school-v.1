package fls.fin.controllers;

import fls.fin.api.PatientRepository;
import fls.fin.entity.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class PatientController {
    private PatientRepository repo;

    @GetMapping("/patients/{id}")
    @ResponseBody
    public Patient findById(@PathVariable Long id) {
        try {
            Optional<Patient> patient = repo.findById(id);
            return patient.get();
        } catch (Exception e) {
            System.out.println("Could not get the patient by id");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/patients")
    @ResponseBody
    public Patient findByName(@RequestParam String name) {
        try {
            Optional<Patient> patient = repo.findByName(name);
            return patient.get();
        } catch (Exception e) {
            System.out.println("Could not get the patient by name");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/patients")
    @ResponseBody
    public ArrayList<Patient> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Could not get patients");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @PostMapping("/patients")
    @ResponseBody
    public Patient savePatient(@RequestBody Patient patient) {
        return repo.save(patient);
    }

    @PostMapping("/patients")
    @ResponseBody
    public Patient updatePatient(@RequestBody Patient patient) {
        return repo.save(patient);
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping("/patients")
    public void delete(@RequestBody Patient patient) {
        repo.delete(patient);
    }
}
