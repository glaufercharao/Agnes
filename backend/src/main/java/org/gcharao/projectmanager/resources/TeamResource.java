package org.gcharao.projectmanager.resources;

import org.gcharao.projectmanager.dtos.TeamDTO;
import org.gcharao.projectmanager.services.ServiceTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team")
public class TeamResource {

    @Autowired
    private ServiceTeam service;


    @GetMapping
    public ResponseEntity<List<TeamDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeamDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TeamDTO> save(@RequestBody TeamDTO team){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(team));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
