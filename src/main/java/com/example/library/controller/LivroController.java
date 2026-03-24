package com.example.library.controller;

import com.example.library.entity.LivroEntity;
import com.example.library.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroEntity>> findAll() {
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(livroService.findById(id));
    }

    @PostMapping ResponseEntity<LivroEntity> save(@RequestBody LivroEntity livroEntity) {
        LivroEntity request = livroService.save(livroEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
