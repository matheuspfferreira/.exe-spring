package com.example.order.controller;

import com.example.order.entity.PedidoEntity;
import com.example.order.service.PedidoService;
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
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoEntity> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidoEntity>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @PostMapping
    ResponseEntity<PedidoEntity> save(@RequestBody PedidoEntity pedidoEntity) {
        PedidoEntity request = pedidoService.save(pedidoEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
