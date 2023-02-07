package com.paracasa.spring.app.security.ordenadoresService;


import com.paracasa.spring.app.model.Ordenadores;
import com.paracasa.spring.app.repository.OrdenadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OrdenadoresService implements IOrdenadoresService {
    @Autowired
    private OrdenadoresRepository ordenadoresRepository;

    public Object findAll() {
        return this.ordenadoresRepository.findAll();
    }

    @Override
    public Optional<Ordenadores> findById(Long id) {
        return ordenadoresRepository.findById(id);
    }

    @Override
    public Ordenadores create(Ordenadores ordenadores) {
        return ordenadoresRepository.save(ordenadores);
    }

    @Override
    public Ordenadores update(Ordenadores ordenadores) {
        Ordenadores currentOrd = ordenadoresRepository.findById(ordenadores.getId()).get();
        currentOrd.setPrice(ordenadores.getPrice());
        currentOrd.setName(ordenadores.getName());
        currentOrd.setDescription(ordenadores.getDescription());

        return ordenadoresRepository.save(currentOrd);
    }
    @Override
    public void delete(Long id) {
        Optional<Ordenadores> ordenadores = ordenadoresRepository.findById(id);
        System.out.println(ordenadores);
        ordenadoresRepository.deleteById(id);
    }

}
