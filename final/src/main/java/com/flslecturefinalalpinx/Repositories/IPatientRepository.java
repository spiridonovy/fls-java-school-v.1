package com.flslecturefinalalpinx.Repositories;

import com.flslecturefinalalpinx.Models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface IPatientRepository extends CrudRepository<Patient,Integer> {

    Patient findById (int id);

    ArrayList<Patient> findAll();

    ArrayList<Patient> findByName(String name);
}