package com.flslecturefinalalpinx.Controllers;

import com.flslecturefinalalpinx.Exceptions.NoContentException;
import com.flslecturefinalalpinx.Models.Doctor;
import com.flslecturefinalalpinx.Repositories.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class DoctorController {

    private IDoctorRepository doctorRepository;

    @Autowired
    public DoctorController(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/doctor/{id}")
    @ResponseBody
    public Doctor FindById(@PathVariable int id) {
        var doctor = doctorRepository.findById(id);
        if (doctor == null) throw new NoContentException();
        return doctor;
    }

    @GetMapping("/doctor/findAll")
    @ResponseBody
    public ArrayList<Doctor> FindAll() {
        var doctor = doctorRepository.findAll();
        if (doctor == null || doctor.isEmpty()) throw new NoContentException();
        return doctor;
    }

    @PostMapping("/doctor")
    @ResponseBody
    public Doctor Create(@RequestBody() String name) {
        return doctorRepository.save(new Doctor(name));
    }

    @GetMapping("/doctor")
    @ResponseBody
    public ArrayList<Doctor> FindByName(@RequestParam(name = "name") String name) {
        var doctor = doctorRepository.findByName(name);
        if (doctor == null || doctor.isEmpty()) throw new NoContentException();
        return doctor;
    }
}
