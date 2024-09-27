package org.gcharao.projectmanager.services;

import org.gcharao.projectmanager.dtos.TaskDTO;
import org.gcharao.projectmanager.enums.Status;

import java.util.List;


public interface ServiceTask {
    List<TaskDTO> findAll();
    List<TaskDTO> findTask(Status status);

    TaskDTO findById(Long id);
    TaskDTO save(TaskDTO task);
    void delete(Long id);

}
