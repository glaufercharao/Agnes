package org.gcharao.projectmanager.services;

import org.gcharao.projectmanager.dtos.ClientDTO;

import java.util.List;


public interface ServiceClient {
    List<ClientDTO> findAll();
    ClientDTO findById(Long id);
    ClientDTO save(ClientDTO client);
    void delete(Long id);

}
