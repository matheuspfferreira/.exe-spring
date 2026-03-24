package com.example.department.controller;

import com.example.department.entity.DepartamentoEntity;
import com.example.department.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoEntity>> findAll() {
        return ResponseEntity.ok().body(departamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DepartamentoEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(departamentoService.findById(id));
    }

    @PostMapping
    ResponseEntity<DepartamentoEntity> save(@RequestBody DepartamentoEntity departamentoEntity) {
        DepartamentoEntity request = departamentoService.save(departamentoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
