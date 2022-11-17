package com.egg.news.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.egg.news.enumerators.Rol;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")

    private Long id;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Usuario(String email, String password, Rol rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    
}
