package fls.alexKartFinal.controllers;

import fls.alexKartFinal.services.*;
import fls.alexKartFinal.entities.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List getAll() {
        return doctorService.getAllDoctors();
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }
}
