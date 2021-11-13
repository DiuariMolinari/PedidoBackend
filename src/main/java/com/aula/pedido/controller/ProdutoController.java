package com.aula.pedido.controller;

import com.aula.pedido.entity.Produto;
import com.aula.pedido.repository.PedidoRepository;
import com.aula.pedido.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto c = repository.save(produto);
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        //@RequestParam(required = false) long idPedido
        //if (idPedido != null && idPedido != 0)
        //{
        //    List<Produto> m = repository.findByPedido(idPedido);
        //    return ResponseEntity.ok(m);
        //}
        return ResponseEntity.ok(repository.findAll());
    }
}
