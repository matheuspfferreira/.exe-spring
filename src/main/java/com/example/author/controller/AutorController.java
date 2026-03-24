package com.example.author.controller;

import com.example.author.entity.AutorEntity;
import com.example.author.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorEntity> findAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AutorEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(autorService.findById(id));
    }

    @PostMapping
    ResponseEntity<AutorEntity> save(@RequestBody AutorEntity autorEntity) {
        AutorEntity request = autorService.save(autorEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
