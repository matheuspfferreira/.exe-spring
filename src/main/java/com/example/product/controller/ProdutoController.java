package com.example.product.controller;

import com.example.product.entity.ProdutoEntity;
import com.example.product.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoEntity> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @PostMapping
    ResponseEntity<ProdutoEntity> save(@RequestBody ProdutoEntity produtoEntity) {
        ProdutoEntity request = produtoService.save(produtoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
