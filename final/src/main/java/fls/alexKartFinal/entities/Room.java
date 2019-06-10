package fls.alexKartFinal.entities;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    protected Room(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    public Room(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
