package com.example.library.service;

import com.example.library.entity.LivroEntity;
import com.example.library.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;;

    public List<LivroEntity> findAll() {
        return livroRepository.findAll();
    }

    public Optional<LivroEntity> findById(Long id) {
        return livroRepository.findById(id);
    }

    public LivroEntity save(LivroEntity livroEntity) {
        return livroRepository.save(livroEntity);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }
}
