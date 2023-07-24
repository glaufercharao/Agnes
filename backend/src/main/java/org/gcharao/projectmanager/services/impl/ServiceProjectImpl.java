package org.gcharao.projectmanager.services.impl;

import org.gcharao.projectmanager.dtos.ProjectDTO;
import org.gcharao.projectmanager.dtos.ProjectPersistDTO;
import org.gcharao.projectmanager.entities.Project;
import org.gcharao.projectmanager.mapper.Mappable;
import org.gcharao.projectmanager.repositories.ProjectRepository;
import org.gcharao.projectmanager.services.ServiceProject;
import org.gcharao.projectmanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProjectImpl implements Mappable, ServiceProject {

    @Autowired
    private ProjectRepository repository;
    @Override
    public List<ProjectDTO> findAll() {
        return map(repository.findAll(), ProjectDTO.class);
    }

    @Override

    public ProjectDTO findById(Long id) {
        Optional<Project> project = repository.findById(id);
        if (!project.isPresent()){
            throw new ResourceNotFoundException("Projeto "+ id +" não encontrado.");
        }
        return map(project.get(), ProjectDTO.class);
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {
        return map(repository.save(map(project, Project.class)), ProjectDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Project> project = repository.findById(id);
        if (!project.isPresent()){
            throw new DataIntegrityViolationException("Projeto não encontrado!");
        }
        repository.deleteById(id);
    }
}
