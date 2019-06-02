package com.flslecturefinalalpinx.Repositories;

import com.flslecturefinalalpinx.Models.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;



@Repository
public interface IDoctorRepository extends CrudRepository<Doctor,Integer> {

    Doctor findById (int id);

    ArrayList<Doctor> findByName(String name);
}
