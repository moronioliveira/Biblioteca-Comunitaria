package com.moronioliveira.Biblioteca_Comunitaria.controller.dtos;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class EmprestimoDTO {
    @NotNull
    private Usuario usuario;
    @NotNull
    private Livro livro;
    @NotNull
    private LocalDateTime dataEmprestimo;
    @NotNull
    private String dataDevolucao;
}
