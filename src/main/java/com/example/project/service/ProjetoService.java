package com.example.project.service;

import com.example.product.entity.ProdutoEntity;
import com.example.product.repository.ProdutoRepository;
import com.example.project.entity.ProjetoEntity;
import com.example.project.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoEntity> findAll() {
        return projetoRepository.findAll();
    }

    public Optional<ProjetoEntity> findById(Long id) {
        return projetoRepository.findById(id);
    }

    public ProjetoEntity save(ProjetoEntity projeto) {
        return projetoRepository.save(projeto);
    }

    public void delete(Long id) {
        projetoRepository.deleteById(id);
    }
}
