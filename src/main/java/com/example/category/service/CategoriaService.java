package com.example.category.service;

import com.example.category.entity.CategoriaEntity;
import com.example.category.repository.CategoriaRepository;
import com.example.library.entity.LivroEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaEntity> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<CategoriaEntity> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public CategoriaEntity save(CategoriaEntity categoriaEntity) {
        return categoriaRepository.save(categoriaEntity);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
