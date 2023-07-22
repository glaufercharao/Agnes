package org.gcharao.projectmanager.services.impl;

import org.gcharao.projectmanager.dtos.ClientDTO;
import org.gcharao.projectmanager.entities.Client;
import org.gcharao.projectmanager.mapper.Mappable;
import org.gcharao.projectmanager.repositories.ClientRepository;
import org.gcharao.projectmanager.services.ServiceClient;
import org.gcharao.projectmanager.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClientImpl implements Mappable, ServiceClient {

    @Autowired
    private ClientRepository repository;
    @Override
    public List<ClientDTO> findAll() {
        return map(repository.findAll(), ClientDTO.class);
    }

    @Override

    public ClientDTO findById(Long id) {
        Optional<Client> client = repository.findById(id);
        if (!client.isPresent()){
            throw new ResourceNotFoundException("Cliente "+ id +" não encontrado.");
        }
        return map(client.get(), ClientDTO.class);
    }

    @Override
    public ClientDTO save(ClientDTO client) {
        return map(repository.save(map(client, Client.class)), ClientDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Client> client = repository.findById(id);
        if (!client.isPresent()){
            throw new DataIntegrityViolationException("Cliente não encontrado!");
        }
        repository.deleteById(id);
    }
}
