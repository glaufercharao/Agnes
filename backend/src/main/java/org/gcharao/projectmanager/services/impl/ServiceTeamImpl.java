package org.gcharao.projectmanager.services.impl;

import org.gcharao.projectmanager.dtos.TeamDTO;
import org.gcharao.projectmanager.entities.Team;
import org.gcharao.projectmanager.mapper.Mappable;
import org.gcharao.projectmanager.repositories.TeamRepository;
import org.gcharao.projectmanager.services.ServiceTeam;
import org.gcharao.projectmanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTeamImpl implements Mappable, ServiceTeam {

    @Autowired
    private TeamRepository repository;

    @Override
    public List<TeamDTO> findAll() {
        return map(repository.findAll(), TeamDTO.class);
    }

    @Override
    public TeamDTO findById(Long id) {
        Optional<Team> team = repository.findById(id);
        if (!team.isPresent()){
            throw new ResourceNotFoundException("Time "+ id +" não encontrado.");
        }
        return map(team.get(), TeamDTO.class);
    }

    @Override
    public TeamDTO save(TeamDTO team) {
        return map(repository.save(map(team, Team.class)), TeamDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Team> team = repository.findById(id);
        if (!team.isPresent()){
            throw new DataIntegrityViolationException("Time não encontrado!");
        }
        repository.deleteById(id);
    }
}
