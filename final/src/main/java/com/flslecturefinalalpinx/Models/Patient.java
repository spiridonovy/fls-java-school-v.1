package com.flslecturefinalalpinx.Models;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "patient", schema = "public")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int sex;

    private Date dayofbirth;

    public Patient() {
    }

    public Patient(String name,
                   Date dayofbirth,
                   int sex) {
        this.name = name;
        this.dayofbirth = dayofbirth;
        this.sex = sex;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getDayofbirth() {
        return dayofbirth;
    }

    public void setDayofbirth(Date dayofbirth) {
        this.dayofbirth = dayofbirth;
    }
}
