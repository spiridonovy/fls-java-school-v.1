package fls.fin.entity;

import fls.fin.FinApplication;
import fls.fin.lib.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="studies")
public class Study {
    @Id
    @GeneratedValue
    private Long id;
    private Patient patient;
    private Status status;
    private String description;
    @Column(name="planned_start_time")
    private Date plannedStartTime;
    @Column(name="planned_end_time")
    private Date plannedEndTime;

    public Study(Patient patient, Status status, Date plannedStartTime) {
        this.patient = patient;
        this.status = status;
        this.plannedStartTime = plannedStartTime;
    }

    public Study(Patient patient, Status status, Date plannedStartTime, Date plannedEndTime) {
        this.patient = patient;
        this.status = status;
        this.plannedStartTime = plannedStartTime;
        this.plannedEndTime = plannedEndTime;
    }

    public Study(Patient patient, Status status, String description, Date plannedStartTime, Date plannedEndTime) {
        this.patient = patient;
        this.status = status;
        this.description = description;
        this.plannedStartTime = plannedStartTime;
        this.plannedEndTime = plannedEndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(Date plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public Date getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(Date plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Study study = (Study) o;
        return id.equals(study.id) &&
                Objects.equals(patient, study.patient) &&
                status == study.status &&
                Objects.equals(plannedStartTime, study.plannedStartTime) &&
                Objects.equals(plannedEndTime, study.plannedEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, status, plannedStartTime, plannedEndTime);
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", patient=" + patient +
                ", status=" + status +
                ", plannedStartTime=" + FinApplication.sdfwt.format(plannedStartTime) +
                ", plannedEndTime=" + FinApplication.sdfwt.format(plannedEndTime)  +
                '}';
    }
}
