package com.example.department.service;

import com.example.client.entity.ClienteEntity;
import com.example.client.repository.ClienteRepository;
import com.example.department.entity.DepartamentoEntity;
import com.example.department.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<DepartamentoEntity> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoEntity> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public DepartamentoEntity save(DepartamentoEntity departamentoEntity) {
        return departamentoRepository.save(departamentoEntity);
    }

    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }
}
