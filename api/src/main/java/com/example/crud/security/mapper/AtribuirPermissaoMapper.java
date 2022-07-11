package com.example.crud.security.mapper;

import com.example.crud.security.controller.request.AtribuirPermissaoRequest;
import com.example.crud.security.model.Permissao;
import org.modelmapper.ModelMapper;

public class AtribuirPermissaoMapper {
    public static Permissao toEntity(AtribuirPermissaoRequest request){
        return new ModelMapper().map(request, Permissao.class);
    }
}
