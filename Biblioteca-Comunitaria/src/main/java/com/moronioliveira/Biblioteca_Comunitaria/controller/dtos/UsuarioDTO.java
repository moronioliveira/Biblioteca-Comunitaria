package com.moronioliveira.Biblioteca_Comunitaria.controller.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @Column(name = "senha", length = 10)
    private String senha;
    @Column(name = "numeroCelular", length = 13)
    private Long numeroCelular;
    @jakarta.validation.constraints.NotBlank(message = "Por favor insira um e-mail")
    private String email;
    @jakarta.validation.constraints.NotBlank(message = "Esse campo não pode estar em branco")
    private String name;
}
