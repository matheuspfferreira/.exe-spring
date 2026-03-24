package com.example.task.service;

import com.example.supplier.entity.FornecedorEntity;
import com.example.supplier.repository.FornecedorRepository;
import com.example.task.entity.TarefaEntity;
import com.example.task.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaEntity> findAll() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaEntity> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public TarefaEntity save(TarefaEntity tarefaEntity) {
        return tarefaRepository.save(tarefaEntity);
    }

    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }

}
