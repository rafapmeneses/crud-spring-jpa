package com.example.crud.security.repository;

import com.example.crud.security.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Page<Usuario> findAllByIdIn(List<Long> usuarioId, Pageable pageable);

    @Query("SELECT u FROM Usuario u WHERE u.id IN ?1 AND (u.nome LIKE ?2% OR u.email LIKE ?3%)")
    Page<Usuario> findAllByIdInAndEmailOrNome(List<Long> usuarioId, String nome, String email, Pageable pageable);

    @Query("SELECT u FROM Usuario u WHERE u.nome LIKE ?1% OR u.email LIKE ?2%")
    Page<Usuario> findByEmailOrNome(String nome, String email, Pageable pageable);

}

