package com.aula.pedido.repository;

import com.aula.pedido.entity.Pedido;
import com.aula.pedido.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("select m from Pedido m where m.numero = :numero order by m.id desc")
    List<Pedido> findByNumero(long numero);
}
