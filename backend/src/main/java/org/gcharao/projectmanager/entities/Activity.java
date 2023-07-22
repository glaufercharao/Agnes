package org.gcharao.projectmanager.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.gcharao.projectmanager.enums.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @CreatedDate
    private Instant initialDate;
    private Instant finalDate;
    @OneToMany(mappedBy = "activity")
    private List<Task> tasks = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
