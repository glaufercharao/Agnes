package org.gcharao.projectmanager.services.impl;

import org.gcharao.projectmanager.dtos.ActivityDTO;
import org.gcharao.projectmanager.entities.Activity;
import org.gcharao.projectmanager.mapper.Mappable;
import org.gcharao.projectmanager.repositories.ActivityRepository;
import org.gcharao.projectmanager.services.ServiceActivity;
import org.gcharao.projectmanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceActivityImpl implements Mappable, ServiceActivity {

    @Autowired
    private ActivityRepository repository;
    @Override
    public List<ActivityDTO> findAll() {
        return map(repository.findAll(), ActivityDTO.class);
    }

    @Override
    public ActivityDTO findById(Long id) {
        Optional<Activity> activity = repository.findById(id);
        if (!activity.isPresent()){
            throw new ResourceNotFoundException("Atividade "+ id +" não encontrado.");
        }
        return map(activity.get(), ActivityDTO.class);
    }

    @Override
    public ActivityDTO save(ActivityDTO activity) {
        return map(repository.save(map(activity, Activity.class)), ActivityDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Activity> activity = repository.findById(id);
        if (!activity.isPresent()){
            throw new DataIntegrityViolationException("Atividade não encontrado!");
        }
        repository.deleteById(id);
    }
}
