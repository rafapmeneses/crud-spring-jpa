package com.example.crud.controller.request;

import lombok.Data;

@Data
public class UserRequest {
    private String nome;
    private String email;
    private String senha;
}
