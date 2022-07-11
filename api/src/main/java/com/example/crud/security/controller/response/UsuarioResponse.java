package com.example.crud.security.controller.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
}
