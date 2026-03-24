package com.example.supplier.controller;

import com.example.product.entity.ProdutoEntity;
import com.example.product.service.ProdutoService;
import com.example.supplier.entity.FornecedorEntity;
import com.example.supplier.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorEntity> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FornecedorEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(fornecedorService.findById(id));
    }

    @PostMapping
    ResponseEntity<FornecedorEntity> save(@RequestBody FornecedorEntity fornecedorEntity) {
        FornecedorEntity request = fornecedorService.save(fornecedorEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
