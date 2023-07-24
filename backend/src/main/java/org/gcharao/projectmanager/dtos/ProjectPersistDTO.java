package org.gcharao.projectmanager.dtos;

import lombok.Data;
import org.gcharao.projectmanager.enums.Status;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class ProjectPersistDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Status status;

}
