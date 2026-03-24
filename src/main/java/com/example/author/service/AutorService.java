package com.example.author.service;

import com.example.author.entity.AutorEntity;
import com.example.author.repository.AutorRepository;
import com.example.product.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<AutorEntity> findAll() {
        return autorRepository.findAll();
    }

    public Optional<AutorEntity> findById(Long id) {
        return autorRepository.findById(id);
    }

    public AutorEntity save(AutorEntity autorEntity ) {
        return autorRepository.save(autorEntity);
    }

    public void delete(Long id) {
        autorRepository.deleteById(id);
    }
}
