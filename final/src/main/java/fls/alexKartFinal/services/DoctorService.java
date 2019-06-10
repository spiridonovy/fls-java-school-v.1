package fls.alexKartFinal.services;

import fls.alexKartFinal.repos.*;
import fls.alexKartFinal.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return this.doctorRepository.save(doctor);
    }
}
