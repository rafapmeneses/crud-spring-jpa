package com.example.crud.security.mapper;

import com.example.crud.security.controller.request.UsuarioRequest;
import com.example.crud.security.controller.response.UsuarioResponse;
import com.example.crud.security.model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static List<UsuarioResponse> toListUsuario(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return new ModelMapper().map(entity, UsuarioResponse.class);
    }

    public static Usuario toEntity(UsuarioRequest request){
        return new ModelMapper().map(request, Usuario.class);
    }
}
