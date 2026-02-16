package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @jakarta.validation.constraints.NotBlank(message = "Esse campo não pode estar em branco" )
    private String name;
    @jakarta.validation.constraints.NotBlank(message =  "Por favor insira um e-mail" )
    private String email;
    @jakarta.validation.constraints.NotNull(message = "Por favor insira um numero de celular" )
    @Column(name = "numeroCelular", length = 13)
    private Long numeroCelular;
}
