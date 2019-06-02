package com.flslecturefinalalpinx.Models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "procedure", schema = "public")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int patient;

    public String description;

    public int status;

    public Date starttime;

    public Date endtime;

    public int doctor;

    public int room;

    public Procedure() {
    }

    public Procedure(
            int patient,
            String description,
            int status,
            Date starttime,
            Date endtime,
            int doctor,
            int room)
    {
        this.patient = patient;
        this.description = description;
        this.status = status;
        this.starttime=starttime;
        this.endtime=endtime;
        this.doctor=doctor;
        this.room=room;
    }

    public int getId() {
        return id;
    }


}
