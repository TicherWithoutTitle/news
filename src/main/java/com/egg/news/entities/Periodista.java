package com.egg.news.entities;

import java.util.List;
import java.util.Date;

import javax.persistence.Entity;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

import com.egg.news.enumerators.Rol;

@Entity
public class Periodista extends Usuario {

    @OneToMany
    private List<Noticia> misNoticias;
    private Integer sueldoMensual;

    public Periodista(Long id, String email, String password, Date fechaDeAlta, Boolean active, Rol rol,
            List<Noticia> misNoticias, Integer sueldoMensual) {
        super(id, email, password, fechaDeAlta, active, rol);
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }

    public Periodista() {

    }

    public List<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(List<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public String toString() {
        return "Periodista [sueldoMensual=" + sueldoMensual + "]";
    }
}
