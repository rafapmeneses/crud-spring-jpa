package com.example.crud.security.controller;

import com.example.crud.security.controller.request.AtribuirPermissaoRequest;
import com.example.crud.security.controller.request.UsuarioRequest;
import com.example.crud.security.controller.response.UsuarioResponse;
import com.example.crud.security.service.AtribuirPermissaoService;
import com.example.crud.security.service.CriarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private CriarUsuarioService criarUsuarioService;

    @Autowired
    private AtribuirPermissaoService atribuirPermissaoService;

    @PostMapping("/cadastrar")
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest criarUsuarioRequest) {
        return criarUsuarioService.incluir(criarUsuarioRequest);
    }

    @PutMapping("/permissao/{id}")
    public void atribuirPermissao(@PathVariable Long id, @RequestBody AtribuirPermissaoRequest atribuirPermissaoRequest) {
        atribuirPermissaoService.atribuirPermissao(id, atribuirPermissaoRequest);
    }
}
