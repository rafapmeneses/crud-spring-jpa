package com.example.crud.controller;

import com.example.crud.security.controller.request.UsuarioRequest;
import com.example.crud.security.controller.response.UsuarioResponse;
import com.example.crud.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/listar")
    public List<UsuarioResponse> buscarUsuarios(){
        return mainService.buscarUsuarios();
    }

    @GetMapping("/listar/{id}")
    public UsuarioResponse buscarUsuario(@PathVariable Long id){
        return mainService.buscarUsuario(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPessoa(@PathVariable Long id) {
        mainService.deletarPessoa(id);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizarPessoa(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {
        mainService.atualizarPessoa(id, usuarioRequest);
    }

}
