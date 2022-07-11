package com.example.crud.services;

import com.example.crud.security.controller.request.UsuarioRequest;
import com.example.crud.security.controller.response.UsuarioResponse;
import com.example.crud.security.mapper.UsuarioMapper;
import com.example.crud.security.model.Usuario;
import com.example.crud.security.repository.UsuarioRepository;
import com.example.crud.security.service.BuscarUsuarioService;
import com.example.crud.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    UsuarioAutenticadoService usuarioAutenticadoService;

    public List<UsuarioResponse> buscarUsuarios() {
        return UsuarioMapper.toListUsuario(usuarioRepository.findAll());
    }

    public UsuarioResponse buscarUsuario(Long id) {
        return UsuarioMapper.toResponse(buscarUsuarioService.porId(id));
    }

    public void deletarPessoa(Long id){
        Usuario usuario = usuarioAutenticadoService.get();
        if(!usuario.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Sem permissão.");
        }
        usuarioRepository.deleteById(id);
    }

    public void atualizarPessoa(Long id, UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioAutenticadoService.get();

        if(!usuario.getId().equals(id)){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Sem permissão.");
        }

//        Usuario usuario = buscarUsuarioService.porId(id);
        if(usuarioRequest.getEmail() != null){
            usuario.setEmail(usuarioRequest.getEmail());
        }
        if(usuarioRequest.getNome() != null){
            usuario.setNome(usuarioRequest.getNome());
        }
        if(usuarioRequest.getSenha() != null){
            usuario.setSenha(usuarioRequest.getSenha());
        }

        usuario.setDataAtualizacao(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }

}
