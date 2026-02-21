package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean emprestado;
    @jakarta.validation.constraints.NotNull(message = "O livro não pode ser registrado sem um ISBN" )
    private String isbn;
    @jakarta.validation.constraints.NotBlank(message = "Por favor insira um nome")
    private String name;
    @jakarta.validation.constraints.NotBlank(message = "Por favor insira um autor")
    private String autor;
    @jakarta.validation.constraints.NotBlank(message = "Por favor insira um genero")
    private String genero;
    @jakarta.validation.constraints.NotBlank(message = "Por favor insira uma data correta")
    @Column(name = "dataDevoluçao", length = 15)
    private String dataDevolucao;
}
