package com.paracasa.spring.app.security.componentesService;


import com.paracasa.spring.app.model.Componentes;

import java.util.Optional;

public interface IComponentesService {

    Object findAll();
    Optional<Componentes> findById(Long id);
    Componentes create(Componentes Componentes);
    Componentes update(Componentes Componentes);
    void delete(Long id);
}
