package com.aula.pedido.repository;

import com.aula.pedido.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select m from Produto m where m.pedido.id = :idPedido order by m.id desc")
    List<Produto> findByPedido(long idPedido);
}