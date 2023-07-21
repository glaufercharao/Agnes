package org.gcharao.projectmanager.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.gcharao.projectmanager.enums.Status;

import java.time.Instant;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Instant initialDate;
    private Instant finalDate;
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
}
