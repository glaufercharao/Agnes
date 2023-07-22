package org.gcharao.projectmanager.services;

import org.gcharao.projectmanager.dtos.ActivityDTO;
import org.gcharao.projectmanager.dtos.TeamDTO;

import java.util.List;


public interface ServiceTeam {
    List<TeamDTO> findAll();

    TeamDTO findById(Long id);
    TeamDTO save(TeamDTO team);
    void delete(Long id);

}
