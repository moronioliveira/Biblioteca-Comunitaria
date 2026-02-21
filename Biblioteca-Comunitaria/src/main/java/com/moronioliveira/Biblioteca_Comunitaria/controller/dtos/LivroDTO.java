package com.moronioliveira.Biblioteca_Comunitaria.controller.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {
    @NotNull(message = "Envie um nome")
    private String name;
    @NotNull(message = "Envie um genero")
    private String genero;
    @NotNull(message = "Envie um isbn")
    private String isbn;
    @NotNull(message = "Envie um autor")
    private String autor;
    @NotNull(message = "Por favor insira uma data correta")
    private String dataDevolucao;
}
