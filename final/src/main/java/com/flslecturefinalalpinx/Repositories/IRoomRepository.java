package com.flslecturefinalalpinx.Repositories;

import com.flslecturefinalalpinx.Models.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IRoomRepository extends CrudRepository<Room, Integer> {

    Room findById(int id);

    ArrayList<Room> findAll();

    ArrayList<Room> findByName(String name);
}
