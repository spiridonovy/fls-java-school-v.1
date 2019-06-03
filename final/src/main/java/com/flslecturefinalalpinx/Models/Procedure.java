package com.flslecturefinalalpinx.Models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "procedure", schema = "public")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int patient;

    private String description;

    private int status;

    private Time starttime;

    private Time endtime;

    private Date date;

    private int doctor;

    private int room;

    public Procedure() {
    }

    public Procedure(
            int patient,
            String description,
            int status,
            Time starttime,
            Time endtime,
            Date date,
            int doctor,
            int room) {
        this.patient = patient;
        this.description = description;
        this.status = status;
        this.starttime = starttime;
        this.endtime = endtime;
        this.date = date;
        this.doctor = doctor;
        this.room = room;
    }

    public int getId() {
        return id;
    }


    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
