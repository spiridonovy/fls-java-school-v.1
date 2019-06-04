package application.services;

import application.models.Doctor;

import java.util.List;

public interface DoctorService {
    List getAllDoctors();

    Doctor addDoctor(Doctor doctor);
}
