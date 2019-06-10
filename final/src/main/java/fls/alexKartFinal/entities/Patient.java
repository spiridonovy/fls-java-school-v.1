package fls.alexKartFinal.entities;

import javax.persistence.*;

@Entity
@Table(name="patient")
public class Patient {

    protected Patient(){}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="sex")
    private String sex;

    public Patient(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
