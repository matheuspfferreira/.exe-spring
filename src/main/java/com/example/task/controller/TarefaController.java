package com.example.task.controller;

import com.example.supplier.entity.FornecedorEntity;
import com.example.supplier.service.FornecedorService;
import com.example.task.entity.TarefaEntity;
import com.example.task.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<TarefaEntity> findAll() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(tarefaService.findById(id));
    }

    @PostMapping
    ResponseEntity<TarefaEntity> save(@RequestBody TarefaEntity tarefaEntity) {
        TarefaEntity request = tarefaService.save(tarefaEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
