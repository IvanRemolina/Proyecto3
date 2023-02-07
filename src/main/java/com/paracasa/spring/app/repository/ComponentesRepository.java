package com.paracasa.spring.app.repository;

import com.paracasa.spring.app.model.Componentes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentesRepository extends JpaRepository<Componentes, Long> {
}