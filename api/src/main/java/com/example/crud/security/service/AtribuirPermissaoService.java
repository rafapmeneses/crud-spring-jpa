package com.example.crud.security.service;

import com.example.crud.security.controller.request.AtribuirPermissaoRequest;
import com.example.crud.security.mapper.AtribuirPermissaoMapper;
import com.example.crud.security.model.Permissao;
import com.example.crud.security.model.Usuario;
import com.example.crud.security.repository.PermissaoRepository;
import com.example.crud.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtribuirPermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void atribuirPermissao(Long id, AtribuirPermissaoRequest atribuirPermissaoRequest) {
        Permissao permissao = AtribuirPermissaoMapper.toEntity(atribuirPermissaoRequest);
        Usuario usuario = buscarUsuarioService.porId(id);
        usuario.getPermissoes().add(permissao);
        usuarioRepository.save(usuario);
    }
}
