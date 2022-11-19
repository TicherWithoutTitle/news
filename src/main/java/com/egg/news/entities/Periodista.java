package com.egg.news.entities;

import java.util.ArrayList;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Periodista extends Usuario {
    @ManyToOne
    private ArrayList<Noticia> misNoticias;
    private Integer sueldoMensual;
}
