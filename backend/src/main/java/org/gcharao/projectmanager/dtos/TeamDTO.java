package org.gcharao.projectmanager.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}
