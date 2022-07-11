package com.example.crud.security.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private List<Permissao> permissoes;
}
