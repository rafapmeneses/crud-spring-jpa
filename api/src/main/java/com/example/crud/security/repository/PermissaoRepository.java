package com.example.crud.security.repository;

import com.example.crud.security.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
