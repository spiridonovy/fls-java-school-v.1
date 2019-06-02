package com.flslecturefinalalpinx.Models;

import javax.persistence.*;

@Entity
@Table(name = "doctor",schema = "public")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Doctor(){}

    public Doctor(String name){
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
