package com.paracasa.spring.app.controller;

import com.paracasa.spring.app.security.ordenadoresService.OrdenadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrdenadoresController {

    @Autowired
    private OrdenadoresService ordenadoresService;

    @RequestMapping(value="/ordenadores")
    public String index(Model model) {
        model.addAttribute("metaTitle", "Ordenadores");
        model.addAttribute("ordenadores", ordenadoresService.findAll());

        return "ordenadores";
    }

    @RequestMapping(value = "/ordenadores/borrar/{id}", method = RequestMethod.GET)
    public String borrar(@PathVariable("id") long id) {
        ordenadoresService.delete(id);
        return "redirect:/ordenadores";
    }


}