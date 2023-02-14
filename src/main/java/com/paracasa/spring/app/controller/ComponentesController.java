package com.paracasa.spring.app.controller;

import com.paracasa.spring.app.security.componentesService.ComponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComponentesController {

    @Autowired
    private ComponentesService componentesService;

    @RequestMapping(value="/componentes")
    public String index(Model model) {
        model.addAttribute("metaTitle", "Componentes");
        model.addAttribute("componentes", componentesService.findAll());

        return "componentes";
    }

    @RequestMapping(value = "/componentes/borrar/{id}", method = RequestMethod.GET)
    public String borrar(@PathVariable("id") long id) {
        componentesService.delete(id);
        return "redirect:/ordenadores";
    }
}

