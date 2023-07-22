package org.gcharao.projectmanager.resources;

import org.gcharao.projectmanager.dtos.TaskDTO;
import org.gcharao.projectmanager.services.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskResource {

    @Autowired
    private ServiceTask service;


    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO task){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(task));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
