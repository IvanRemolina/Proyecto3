package com.paracasa.spring.app.controller;

import com.paracasa.spring.app.security.ordenadoresService.OrdenadoresService;
import com.paracasa.spring.app.service.roleService.RoleService;
import com.paracasa.spring.app.service.usuarioService.IUsuarioService;
import com.paracasa.spring.app.utils.CheckSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class OrdenadoresController {

    @Autowired
    private OrdenadoresService ordenadoresService;
    @Autowired
    private IUsuarioService userService;

    @Autowired
    private RoleService roleService;
    @RequestMapping(value="/ordenadores")

    public String index(Model model, Authentication auth, HttpSession session) {
        this.checkSession(auth, session,
                userService, roleService);
        model.addAttribute("metaTitle", "Ordenadores");
        model.addAttribute("ordenadores", ordenadoresService.findAll());

        return "ordenadores";
    }

    @RequestMapping(value = "/ordenadores/borrar/{id}", method = RequestMethod.GET)
    public String borrar(@PathVariable("id") long id) {
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