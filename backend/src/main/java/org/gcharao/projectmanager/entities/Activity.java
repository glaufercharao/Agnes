package org.gcharao.projectmanager.entities;

import jakarta.persistence.*;
import lombok.Data;
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
    @OneToMany
    @JoinColumn(name = "activity_id")
    private List<Task> tasks = new ArrayList<>();

    @PrePersist
    public void setup(){
        this.initialDate = Instant.now();
    }
}
