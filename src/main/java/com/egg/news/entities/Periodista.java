package com.egg.news.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Periodista extends Usuario{
    @ManyToOne
    private ArrayList<Noticia> misNoticias;
    private Integer sueldoMensual;
}
