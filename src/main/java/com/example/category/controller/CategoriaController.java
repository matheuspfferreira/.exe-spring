package com.example.category.controller;

import com.example.category.entity.CategoriaEntity;
import com.example.category.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> findAll() {
        return ResponseEntity.ok().body(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoriaService.findById(id));
    }

    @PostMapping
    ResponseEntity<CategoriaEntity> save(@RequestBody CategoriaEntity categoriaEntity) {
        CategoriaEntity request = categoriaService.save(categoriaEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
