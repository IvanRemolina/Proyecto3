package com.paracasa.spring.app.controller;


import com.paracasa.spring.app.model.Ordenadores;
import com.paracasa.spring.app.security.ordenadoresService.OrdenadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AñadirOrdenadoresController {

    @Autowired
    private OrdenadoresService ordenadoresService;

    @GetMapping("/ordenadores/nuevo")
    public String home(Model model){
        Ordenadores ordenadores = new Ordenadores();
        model.addAttribute("ordenadores", ordenadores);
        model.addAttribute("metaTitle", "Añadir ordenadores");

        return "nuevo_ordenador";
    }

    @PostMapping("/ordenadores/nuevo")
    public String create(@Valid @ModelAttribute Ordenadores ordenadores, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "nuevo_ordenador";
        }
        ordenadoresService.create(ordenadores);
        return "redirect:/ordenadores/nuevo";
    }
}
