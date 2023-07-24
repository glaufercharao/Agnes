package org.gcharao.projectmanager.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToMany
    @JoinColumn(name = "activity_id")
    private List<Task> tasks = new ArrayList<>();

    @PrePersist
    public void setup(){
        this.initialDate = Instant.now();
    }
}
