package org.gcharao.projectmanager.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
public class ActivityTaskDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}
