package org.gcharao.projectmanager.entities;

import lombok.Data;
import org.gcharao.projectmanager.enums.Status;

import java.time.Instant;

@Data
public class Project {

    private Long id;
    private String name;
    private String description;
    private Status status;
    private Instant initialDate;
    private Instant finalDate;

}
