package fls.alexKartFinal.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="study")
public class Study {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="status")
    private String status;

    @Column(name="patient")
    private Patient patient;

    @Column(name="description")
    private String description;

    @Column(name="plannedstarttime")
    private Date plannedStartTime;

    @Column(name="estimatedendtime")
    private Date estimatedEndTime;

    protected Study(){}

    public Study(Patient patient, String description, String status, Date plannedStartTime, Date estimatedEndTime) {
        this.patient = patient;
        this.description = description;
        this.status = status;
        this.plannedStartTime = plannedStartTime;
        this.estimatedEndTime = estimatedEndTime;
    }

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public Date getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPlannedStartTime(Date plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public void setEstimatedEndTime(Date estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }
}