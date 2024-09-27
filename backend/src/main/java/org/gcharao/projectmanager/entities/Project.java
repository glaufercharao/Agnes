package org.gcharao.projectmanager.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.gcharao.projectmanager.enums.Status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Instant initialDate;
    private Instant finalDate;

    @OneToMany
    @JoinColumn(name = "project_id")
    private List<Activity> activities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @PrePersist
    public void setup(){
        this.initialDate = Instant.now();
    }
}
