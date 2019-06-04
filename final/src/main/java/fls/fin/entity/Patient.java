package fls.fin.entity;

import fls.fin.FinApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Boolean sex; //true for male; false for female
    private Date dateOfBirth;

    public Patient(String name, Boolean sex) throws ParseException {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = FinApplication.sdf.parse("13.04.1992");
    }

    public Patient(String name, Boolean sex, Date dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id.equals(patient.id) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(sex, patient.sex) &&
                Objects.equals(dateOfBirth, patient.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + ((sex== true)? "Мужской" : "Женский") +
                ", dateOfBirth=" + FinApplication.sdf.format(dateOfBirth) +
                '}';
    }
}
