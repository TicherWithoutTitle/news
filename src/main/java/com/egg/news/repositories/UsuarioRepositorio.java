package com.egg.news.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.news.entities.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    @Query("select u from Usuario u where u.email=:email")
    public Usuario selectByUsername(@Param("email")String email);
}
