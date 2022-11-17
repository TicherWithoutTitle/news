package com.egg.news.drivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.news.entities.Noticia;
import com.egg.news.services.NoticiaService;

@Controller
@RequestMapping("/noticia")
public class NoticiaDriver {
    @Autowired
    NoticiaService ns;

    @GetMapping("/crear")
    public String crear() {
        return "crear.html";
    }

    @PostMapping("/crear_recibir")
    public String crearNoticia(@RequestParam String titulo, String cuerpo, String foto, ModelMap modelo) {
        try {
            ns.crearNoticia(titulo, cuerpo, foto);
            modelo.addAttribute("msg", "EXITAZO PA.");

        } catch (Exception e) {
            modelo.addAttribute("msg", e.getMessage());
        }
        return "crear.html";
    }

    @GetMapping("/listar")
    public String listarNoticias(ModelMap modelo) {
        modelo.addAttribute("lista", ns.listarNoticias());
        return "lista.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificarNoticia(@PathVariable Long id, ModelMap modelo) {
        Noticia noticia = ns.traerNoticiaPorID(id);
        modelo.addAttribute("id", noticia.getId());
        modelo.addAttribute("titulo", noticia.getTitulo());
        modelo.addAttribute("cuerpo", noticia.getCuerpo());
        modelo.addAttribute("foto", noticia.getFoto());
        return "modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificarPost(@RequestParam Long id, String titulo, String cuerpo, String foto) {
        ns.modificarNoticia(id, titulo, cuerpo, foto);
        return "redirect:/noticia/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNoticia(@PathVariable Long id) {
        ns.eliminarNoticia(id);
        return "redirect:/noticia/listar";
    }
}
