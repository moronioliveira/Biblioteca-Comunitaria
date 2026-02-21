package com.moronioliveira.Biblioteca_Comunitaria.controller;

import com.moronioliveira.Biblioteca_Comunitaria.business.LivroService;
import com.moronioliveira.Biblioteca_Comunitaria.controller.dtos.LivroDTO;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")

public class LivroController {
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@Valid @RequestBody LivroDTO dados){

        Livro livroCompleto = new Livro();
        livroCompleto.setAutor(dados.getAutor());
        livroCompleto.setName(dados.getName());
        livroCompleto.setGenero(dados.getGenero());
        livroCompleto.setDataDevolucao(dados.getDataDevolucao());
        livroCompleto.setIsbn(dados.getIsbn());

        Livro livroCriado = livroService.criarLivro
                (livroCompleto);
        return ResponseEntity.ok(livroCriado);
    }
}
