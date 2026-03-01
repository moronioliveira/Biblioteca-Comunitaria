package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_users")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Esse campo não pode estar em branco")
    private String name;
    @NotBlank(message = "Por favor insira um e-mail")
    private String email;
    @Column(name = "numeroCelular", length = 13)
    private Long numeroCelular;
    @NotBlank(message = "Digite uma senha valida")
    @Column(name = "senha", length = 10)
    private String senha;
}
