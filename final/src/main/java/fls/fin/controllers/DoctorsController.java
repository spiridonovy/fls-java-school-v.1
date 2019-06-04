package fls.fin.controllers;

import fls.fin.api.DoctorsRepository;
import fls.fin.entity.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class DoctorsController {
    private DoctorsRepository repo;

    @GetMapping("/doctors/{id}")
    @ResponseBody
    public Doctor findById(@PathVariable Long id) {
        try {
            Optional<Doctor> doctor = repo.findById(id);
            return doctor.get();
        } catch (Exception e) {
            System.out.println("Could not get the doctor by id");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/doctors")
    @ResponseBody
    public Doctor findByName(@RequestParam String name) {
        try {
            Optional<Doctor> doctor = repo.findByName(name);
            return doctor.get();
        } catch (Exception e) {
            System.out.println("Could not get the doctor by name");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/doctors")
    @ResponseBody
    public ArrayList<Doctor> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Could not get doctors");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @PostMapping("/doctors")
    @ResponseBody
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return repo.save(doctor);
    }

    @PostMapping("/doctors")
    @ResponseBody
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return repo.save(doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping("/doctors")
    public void delete(@RequestBody Doctor doctor) {
        repo.delete(doctor);
    }
}
