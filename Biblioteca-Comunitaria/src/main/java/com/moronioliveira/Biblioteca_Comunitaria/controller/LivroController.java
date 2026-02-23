package com.moronioliveira.Biblioteca_Comunitaria.controller;

import com.moronioliveira.Biblioteca_Comunitaria.business.LivroService;
import com.moronioliveira.Biblioteca_Comunitaria.controller.dtos.LivroDTO;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.LivroRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")

public class LivroController {
    private final LivroService livroService;
    private final LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@Valid @RequestBody LivroDTO dados) {

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

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro){
        Livro atualizado =  livroService.atualizar(id, livro);
        return ResponseEntity.ok(atualizado);
    }
}
