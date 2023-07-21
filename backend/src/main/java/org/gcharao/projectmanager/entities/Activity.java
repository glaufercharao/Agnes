package org.gcharao.projectmanager.entities;

import lombok.Data;
import org.gcharao.projectmanager.enums.Status;

import java.time.Instant;
@Data
public class Activity {

    private Long id;
    private String name;
    private Instant initialDate;
    private Instant finalDate;
}
