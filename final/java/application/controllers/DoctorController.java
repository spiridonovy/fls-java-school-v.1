package application.controllers;

import application.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import application.services.DoctorService;

import java.util.List;

@RestController
public class DoctorController {
    private static final Logger logger= LoggerFactory.getLogger(DoctorController.class);

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(Doctor doctor){
        logger.info("Creating Doctor: {}", doctor);
        return doctorService.addDoctor(doctor);
    }

}
