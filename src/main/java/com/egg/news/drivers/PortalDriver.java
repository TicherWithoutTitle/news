package com.egg.news.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.news.services.UsuarioService;

@Controller
@RequestMapping("/")
public class PortalDriver {
    @Autowired
    UsuarioService us;
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrate")
    public String registrate(){
        return "formRegistro.html";
    }
    @PostMapping("/registrate")
    public String registroUsuario(@RequestParam String email, String password){
        us.crearUsuario(email, password);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "formLogin.html";
    }

}
