package com.example.project.controller;

import com.example.product.entity.ProdutoEntity;
import com.example.product.service.ProdutoService;
import com.example.project.entity.ProjetoEntity;
import com.example.project.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<ProjetoEntity> findAll() {
        return projetoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjetoEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(projetoService.findById(id));
    }

    @PostMapping
    ResponseEntity<ProjetoEntity> save(@RequestBody ProjetoEntity projetoEntity) {
        ProjetoEntity request = projetoService.save(projetoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projetoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
