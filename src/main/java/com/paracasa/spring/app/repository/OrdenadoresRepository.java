package com.paracasa.spring.app.repository;

import com.paracasa.spring.app.model.Ordenadores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenadoresRepository extends JpaRepository<Ordenadores, Long> {
}
