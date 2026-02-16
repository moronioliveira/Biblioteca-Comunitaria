package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adress")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "rua")
    private String rua;
    @Column (name = "numero", length = 4)
    private Long numero;
    @Column (name = "bairro")
    private String bairro;
    @Column (name = "cidade")
    private String cidade;
    @Column (name = "estado", length = 3)
    private String estado;
    @Column (name = "cep", length = 9)
    private String cep;
}
