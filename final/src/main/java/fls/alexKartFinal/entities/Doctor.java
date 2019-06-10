package fls.alexKartFinal.entities;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    protected Doctor(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    public Doctor (String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
