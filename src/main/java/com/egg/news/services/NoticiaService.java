package com.egg.news.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.news.entities.Noticia;
import com.egg.news.repositories.NoticiaRepositorie;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepositorie JpaN;

    @Transactional
    public void crearNoticia(String titulo, String cuerpo, String foto) throws Exception {
        validar(titulo, cuerpo);
        Noticia noticia = new Noticia(titulo, cuerpo, foto);
        JpaN.save(noticia);
    }

    @Transactional
    public void modificarNoticia(Long id, String titulo, String cuerpo, String foto) {
        try {
            validar(titulo, cuerpo);
            Noticia noticia = JpaN.findById(id).get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setFoto(foto);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    // public List<Noticia> consultarPorTitulo(String titulo) {
    // return JpaN.buscarPorParteDelTitulo(titulo);
    // }

    @Transactional
    public void eliminarNoticia(Long id) {
        JpaN.deleteById(id);
    }

    public List<Noticia> listarNoticias(){
        return JpaN.findAll();
    }

    public Noticia traerNoticiaPorID(Long id) {
        return JpaN.findById(id).get();
    }

    private void validar(String titulo, String cuerpo) throws Exception {
        if (titulo.isEmpty() || cuerpo.isEmpty()) {
            throw new Exception("Error en la validacion");
        }
    }

}
