package com.paracasa.spring.app.controller;


import com.paracasa.spring.app.model.Ordenadores;
import com.paracasa.spring.app.security.ordenadoresService.OrdenadoresService;
import com.paracasa.spring.app.service.roleService.RoleService;
import com.paracasa.spring.app.service.usuarioService.IUsuarioService;
import com.paracasa.spring.app.utils.CheckSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EditarOrdenadoresController {

    @Autowired
    private OrdenadoresService ordenadoresService;

    @Autowired
    private IUsuarioService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/ordenadores/editar/{id}")
    public String editar(@PathVariable("id") long id, Model model, Authentication auth, HttpSession session) {
        this.checkSession(auth, session,
                userService, roleService);
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
        ordenadoresService.delete(id);
        return "redirect:/ordenadores";
    }



    private void checkSession(Authentication auth, HttpSession session,
                              IUsuarioService userService,
                              RoleService roleService){
        CheckSession currentSession = new CheckSession(auth, session,
                userService, roleService);
        currentSession.validate();
    }
}
