package com.example.supplier.service;

import com.example.product.entity.ProdutoEntity;
import com.example.product.repository.ProdutoRepository;
import com.example.supplier.entity.FornecedorEntity;
import com.example.supplier.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorEntity> findAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<FornecedorEntity> findById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public FornecedorEntity save(FornecedorEntity fornecedorEntity) {
        return fornecedorRepository.save(fornecedorEntity);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
