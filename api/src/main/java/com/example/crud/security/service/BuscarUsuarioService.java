package com.example.crud.security.service;

import com.example.crud.security.model.Usuario;
import com.example.crud.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario porId(Long id){
        return usuarioRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não foi possivel encontrar um usuário com esse id."));
    }
}
