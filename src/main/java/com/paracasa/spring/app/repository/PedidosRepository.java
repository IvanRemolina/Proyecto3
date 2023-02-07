package com.paracasa.spring.app.repository;

import com.paracasa.spring.app.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
