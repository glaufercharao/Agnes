package org.gcharao.projectmanager.resources;

import org.gcharao.projectmanager.dtos.ProjectDTO;
import org.gcharao.projectmanager.dtos.ProjectPersistDTO;
import org.gcharao.projectmanager.services.ServiceProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectResource {

    @Autowired
    private ServiceProject service;


    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> save(@RequestBody ProjectDTO project){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(project));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
