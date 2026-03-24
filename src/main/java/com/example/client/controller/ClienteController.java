package com.example.client.controller;

import com.example.client.entity.ClienteEntity;
import com.example.client.service.ClienteService;
import com.example.library.entity.LivroEntity;
import com.example.library.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> findAll() {
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PostMapping
    ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity clienteEntity) {
        ClienteEntity request = clienteService.save(clienteEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
