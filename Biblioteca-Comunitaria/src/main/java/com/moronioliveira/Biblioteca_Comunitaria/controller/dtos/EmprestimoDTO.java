package com.moronioliveira.Biblioteca_Comunitaria.controller.dtos;

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
public class EmprestimoDTO {
    @NotNull(message = "Envie um Id para o livro")
    @Positive
    private Long livroId;
    @NotNull(message = "Envie um Id para o usuario")
    @Positive
    private Long usuarioId;
}
