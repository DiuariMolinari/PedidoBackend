package com.aula.pedido.controller;

import com.aula.pedido.entity.Pedido;
import com.aula.pedido.entity.Produto;
import com.aula.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        Pedido pedidoNovo = repository.save(pedido);

        List<Produto> produtos = pedidoNovo.getProdutos();

        boolean needResave = false;
        for (Produto prod : produtos) {
            if (prod.getPedido() == null)
            {
                needResave = true;
                prod.setPedido(new Pedido(pedidoNovo.getId()));
            }
        }
        if (needResave)
            pedidoNovo = repository.save(pedidoNovo);

        return ResponseEntity.ok(pedidoNovo);
    }

    @GetMapping
    public List<Pedido> findAll(@RequestParam(required = false, defaultValue = "0") long numero) {
        if (numero > 0) {
            return repository.findByNumero(numero);
        }
        return repository.findAll();
    }
}
