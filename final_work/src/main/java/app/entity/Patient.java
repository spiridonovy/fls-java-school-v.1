package app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "patient_name")
    private String name;

    @Getter @Setter
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Getter @Setter
    @Column(name = "day_of_birth")
    private Date dayOfBirth;

    public Patient(){}

    public Patient(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.dayOfBirth = builder.dayOfBirth;
    }

    public static class Builder {
        private String name;
        private Sex sex;
        private Date dayOfBirth;

        public Builder(String name){
            this.name = name;
        }

        public Builder setSex(Sex sex){
            this.sex = sex;
            return this;
        }

        public Builder setDayOfBirth(Date dayOfBirth){
            this.dayOfBirth = dayOfBirth;
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }
    }
}
