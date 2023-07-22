package org.gcharao.projectmanager.services;

import org.gcharao.projectmanager.dtos.ActivityDTO;

import java.util.List;


public interface ServiceActivity {
    List<ActivityDTO> findAll();

    ActivityDTO findById(Long id);
    ActivityDTO save(ActivityDTO activity);
    void delete(Long id);

}
