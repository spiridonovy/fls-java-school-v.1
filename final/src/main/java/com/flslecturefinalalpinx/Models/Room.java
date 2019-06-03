package com.flslecturefinalalpinx.Models;

import javax.persistence.*;


@Entity
@Table(name = "room", schema = "public")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
