package com.paracasa.spring.app.controller;


import com.paracasa.spring.app.model.Componentes;
import com.paracasa.spring.app.security.componentesService.ComponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class AñadirComponentesController {

@Autowired
private ComponentesService componentesService;

@GetMapping("/componentes/nuevo")
public String home(Model model){
        Componentes componentes = new Componentes();
        model.addAttribute("componentes", componentes);
        model.addAttribute("metaTitle", "Añadir componentes");
        return "nuevo_componente";
        }

@PostMapping("/componentes/nuevo")
public String create(@Valid @ModelAttribute Componentes componentes, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        return "nuevo_componente";
        }
        componentesService.create(componentes);
        return "redirect:/componentes/nuevo";
    }
}