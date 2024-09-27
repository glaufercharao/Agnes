package org.gcharao.projectmanager.dtos;

import lombok.Data;
import org.gcharao.projectmanager.enums.Status;

import java.io.Serializable;
import java.time.Instant;

@Data
public class TaskDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private Status status;
    private Instant initialDate;
    private Instant finalDate;
    private ActivityTaskDTO activity;
}
