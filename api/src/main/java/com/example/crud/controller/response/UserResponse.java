package com.example.crud.controller.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class UserResponse {
    private Long id;
    private String nome;
    private String email;
}
