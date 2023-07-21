package org.gcharao.projectmanager.services.impl;

import org.gcharao.projectmanager.dtos.ProjectDTO;
import org.gcharao.projectmanager.entities.Project;
import org.gcharao.projectmanager.mapper.Mappable;
import org.gcharao.projectmanager.repositories.ProjectRepository;
import org.gcharao.projectmanager.services.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements Mappable, ServiceAll<ProjectDTO> {

    @Autowired
    private ProjectRepository repository;
    @Override
    public List<ProjectDTO> findAll() {
        return map(repository.findAll(), ProjectDTO.class);
    }

    @Override

    public Optional<ProjectDTO> findById(Long id) {
        return Optional.of(map(repository.findById(id), ProjectDTO.class));
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
