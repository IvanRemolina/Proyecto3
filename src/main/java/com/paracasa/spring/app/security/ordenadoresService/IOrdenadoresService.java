package com.paracasa.spring.app.security.ordenadoresService;


import com.paracasa.spring.app.model.Ordenadores;

import java.util.Optional;

public interface IOrdenadoresService {
    Object findAll();
    Optional<Ordenadores> findById(Long id);
    Ordenadores create(Ordenadores Ordenadores);
    Ordenadores update(Ordenadores Ordenadores);
    void delete(Long id);

}
