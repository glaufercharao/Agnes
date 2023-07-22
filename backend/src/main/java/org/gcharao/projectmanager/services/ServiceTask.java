package org.gcharao.projectmanager.services;

import org.gcharao.projectmanager.dtos.TaskDTO;

import java.util.List;


public interface ServiceTask {
    List<TaskDTO> findAll();

    TaskDTO findById(Long id);
    TaskDTO save(TaskDTO task);
    void delete(Long id);

}
