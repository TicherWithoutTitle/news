package com.egg.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.news.entities.Noticia;

@Repository

public interface NoticiaRepositorie extends JpaRepository<Noticia, Long> {
    // @Query("SELECT n FROM NOTICIA n WHERE n.titulo LIKE %?1%")
    // //  @Query("SELECT n FROM NOTICIA n WHERE n.titulo LIKE %:titulo%")
    // //  @Query("SELECT n FROM NOTICIA n WHERE n.titulo LIKE :titulo")
    // public List<Noticia> buscarPorParteDelTitulo(String titulo);
}
