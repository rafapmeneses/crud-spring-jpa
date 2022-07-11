package com.example.crud.security.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UsuarioRequest {
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

}