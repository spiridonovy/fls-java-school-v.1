package application.services;

import application.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.DoctorRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    public static final Logger logger= LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List getAllDoctors() {
        logger.debug("Returning list of all the doctors.");
        return doctorRepository.findAll();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        logger.debug("Save doctor with values {}.", doctor);
        return this.doctorRepository.save(doctor);
    }
}
