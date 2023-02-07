package com.paracasa.spring.app.repository;

import com.paracasa.spring.app.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
