package com.example.client.service;

import com.example.client.entity.ClienteEntity;
import com.example.client.repository.ClienteRepository;
import com.example.library.entity.LivroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteEntity> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public ClienteEntity save(ClienteEntity clienteEntity) {
        return clienteRepository.save(clienteEntity);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
