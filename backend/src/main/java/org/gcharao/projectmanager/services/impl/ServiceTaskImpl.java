package org.gcharao.projectmanager.services.impl;

import org.gcharao.projectmanager.dtos.TaskDTO;
import org.gcharao.projectmanager.entities.Task;
import org.gcharao.projectmanager.enums.Status;
import org.gcharao.projectmanager.mapper.Mappable;
import org.gcharao.projectmanager.repositories.TaskRepository;
import org.gcharao.projectmanager.services.ServiceTask;
import org.gcharao.projectmanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTaskImpl implements Mappable, ServiceTask {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<TaskDTO> findAll() {
        return map(repository.findAll(), TaskDTO.class);
    }

    @Override
    public List<TaskDTO> findTask(Status status) {
        return map(repository.findTaskByStatus(status).orElseThrow(() -> new ResourceNotFoundException("Tarefa com status " + status.getDescricao() + " não encontrada.")), TaskDTO.class);
    }

    @Override
    public TaskDTO findById(Long id) {
        Optional<Task> task = repository.findById(id);
        return map(task.orElseThrow(() -> new ResourceNotFoundException("Tarefa " + id + " não encontrado.")), TaskDTO.class);
    }

    @Override
    public TaskDTO save(TaskDTO task) {
        return map(repository.save(map(task, Task.class)), TaskDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = repository.findById(id);
        if (!task.isPresent()){
            throw new DataIntegrityViolationException("Tarefa não encontrado!");
        }
        repository.deleteById(id);
    }
}
