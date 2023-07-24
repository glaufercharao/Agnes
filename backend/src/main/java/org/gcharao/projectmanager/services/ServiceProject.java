package org.gcharao.projectmanager.services;

import org.gcharao.projectmanager.dtos.ProjectDTO;
import org.gcharao.projectmanager.dtos.ProjectPersistDTO;
import org.gcharao.projectmanager.entities.Project;

import java.util.List;
import java.util.Optional;


public interface ServiceProject {
    List<ProjectDTO> findAll();
    ProjectDTO findById(Long id);
    ProjectDTO save(ProjectDTO project);
    void delete(Long id);

}
