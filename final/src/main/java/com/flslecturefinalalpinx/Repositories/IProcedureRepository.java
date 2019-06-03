package com.flslecturefinalalpinx.Repositories;

import com.flslecturefinalalpinx.Models.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IProcedureRepository extends CrudRepository<Procedure, Integer> {

    Procedure findById(int id);

    ArrayList<Procedure> findAll();

    ArrayList<Procedure> findByPatient(int patient);

    ArrayList<Procedure> findByDoctor(int doctor);

    ArrayList<Procedure> findByRoom(int room);
}


