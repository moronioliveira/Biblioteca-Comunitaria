package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lending")

public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Livro livro;
    private LocalDateTime dataEmprestimo;
    private String dataDevolucao;
}
