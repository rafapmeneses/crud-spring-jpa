package com.example.crud.security.service;

import com.example.crud.security.controller.request.UsuarioRequest;
import com.example.crud.security.controller.response.UsuarioResponse;
import com.example.crud.security.mapper.UsuarioMapper;
import com.example.crud.security.model.Permissao;
import com.example.crud.security.model.Usuario;
import com.example.crud.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CriarUsuarioService {
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioSecuritySerivce buscarUsuarioSecuritySerivce;

    public UsuarioResponse incluir(UsuarioRequest criarUsuarioRequest) {
        Usuario usuario = UsuarioMapper.toEntity(criarUsuarioRequest);

        if(!Objects.isNull(usuarioRepository.findByEmail(usuario.getEmail()))){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Usuario já existe");
        }

        Permissao permissao = new Permissao();
        permissao.setNome("USER");

        List<Permissao> permissoes = new ArrayList<>();
        permissoes.add(permissao);

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setPermissoes(permissoes);

        usuario.setDataAtualizacao(LocalDateTime.now());
        usuario.setDataCriacao(LocalDateTime.now());

        usuarioRepository.save(usuario);
        return UsuarioMapper.toResponse(usuario);
    }
}
