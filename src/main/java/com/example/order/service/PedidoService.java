package com.example.order.service;

import com.example.order.entity.PedidoEntity;
import com.example.order.repository.PedidoRepository;
import com.example.product.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoEntity> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoEntity> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public PedidoEntity save(PedidoEntity pedidoEntity) {
        return pedidoRepository.save(pedidoEntity);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

}
