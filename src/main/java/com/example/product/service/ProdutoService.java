package com.example.product.service;

import com.example.product.entity.ProdutoEntity;
import com.example.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoEntity> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoEntity save(ProdutoEntity produtoEntity) {
        return (ProdutoEntity) produtoRepository.save(produtoEntity);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

}
