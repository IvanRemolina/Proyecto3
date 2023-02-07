package com.paracasa.spring.app.controller;


import com.paracasa.spring.app.model.Ordenadores;
import com.paracasa.spring.app.security.ordenadoresService.OrdenadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EditarOrdenadoresController {

    @Autowired
    private OrdenadoresService ordenadoresService;

    @GetMapping("/ordenadores/editar/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Ordenadores> ordenador = ordenadoresService.findById(id);
        model.addAttribute("ordenador", ordenador);
        model.addAttribute("metaTitle", "Editar ordenador");

        return "editar_ordenador";
    }

    @PostMapping("/ordenadores/editar/{id}")
    public String actualizar(@PathVariable("id") long id, @Valid @ModelAttribute Ordenadores ordenador, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editar_ordenador";
        }
        ordenador.setId(id);
        ordenadoresService.update(ordenador);
        return "redirect:/ordenadores";
    }
}
