package org.gcharao.projectmanager.resources;

import org.gcharao.projectmanager.dtos.ActivityDTO;
import org.gcharao.projectmanager.services.ServiceActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/activity")
public class ActivityResource {

    @Autowired
    private ServiceActivity service;


    @GetMapping
    public ResponseEntity<List<ActivityDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ActivityDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> save(@RequestBody ActivityDTO activity){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(activity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
