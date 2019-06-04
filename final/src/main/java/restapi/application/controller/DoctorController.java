package restapi.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Doctor;
import restapi.application.service.interf.DoctorService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public List getAll() throws NoContentException {
        return doctorService.getAll();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable(value = "id") Long doctorId) throws ItemNotFoundException {
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }
}
