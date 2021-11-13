package com.aula.pedido.controller;

import com.aula.pedido.entity.Pedido;
import com.aula.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        Pedido c = repository.save(pedido);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return repository.findAll();
    }
}
