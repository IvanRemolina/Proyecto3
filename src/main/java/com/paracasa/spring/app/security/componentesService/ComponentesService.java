package com.paracasa.spring.app.security.componentesService;


import com.paracasa.spring.app.model.Componentes;
import com.paracasa.spring.app.repository.ComponentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ComponentesService implements IComponentesService {

    @Autowired
    private ComponentesRepository componentesRepository;

    public Object findAll() {
        return this.componentesRepository.findAll();
    }

    @Override
    public Optional<Componentes> findById(Long id) {
        return componentesRepository.findById(id);
    }

    @Override
    public Componentes create(Componentes componentes) {
        return componentesRepository.save(componentes);
    }

    @Override
    public Componentes update(Componentes componentes) {
        Componentes currentOrd = componentesRepository.findById(componentes.getId()).get();
        currentOrd.setPrice(componentes.getPrice());
        currentOrd.setName(componentes.getName());
        currentOrd.setDescription(componentes.getDescription());

        return componentesRepository.save(currentOrd);
    }
    @Override
    public void delete(Long id) {
        Optional<Componentes> componentes = componentesRepository.findById(id);
        System.out.println(componentes);
        componentesRepository.deleteById(id);
    }

}
