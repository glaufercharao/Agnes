package org.gcharao.projectmanager.dtos;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class ActivityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    @CreatedDate
    private Instant initialDate;
    private Instant finalDate;
    private List<TaskDTO> tasks;
}
