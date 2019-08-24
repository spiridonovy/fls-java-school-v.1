package app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@Table(name = "studies")
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "patient_id")
    private Long patientId;

    @Getter @Setter
    @Column(name = "description")
    private String description;

    @Getter @Setter
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter @Setter
    @Column(name = "start_time")
    private Date startTime;

    @Getter @Setter
    @Column(name = "end_time")
    private Date endTime;

    public Study(){}
}
