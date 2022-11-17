package com.egg.news.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.egg.news.entities.Usuario;
import com.egg.news.enumerators.Rol;
import com.egg.news.repositories.UsuarioRepositorio;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    UsuarioRepositorio JpaUsuario;

    @Transactional
    public void crearUsuario(String email, String password) {
        Usuario usuario = new Usuario(email, password, Rol.USER);
        JpaUsuario.save(usuario);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = JpaUsuario.selectByUsername(username);
        if(usuario!=null){
            List<GrantedAuthority> permission = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+usuario.getRol().toString());
            permission.add(p);
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("user", usuario);
            return new User(usuario.getEmail(), usuario.getPassword(), permission);
        }
        return null;
    }

}
