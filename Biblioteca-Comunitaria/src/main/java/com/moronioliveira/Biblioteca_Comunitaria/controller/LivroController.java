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

    @PostMapping
    public ResponseEntity<Livro> criarLivro(
            @Valid @RequestBody LivroDTO dados) {

        //Objeto
        Livro livroCompleto = new Livro();

        //Settar os atributos
        livroCompleto.setAutor(dados.getAutor());
        livroCompleto.setName(dados.getName());
        livroCompleto.setGenero(dados.getGenero());
        livroCompleto.setDataDevolucao(dados.getDataDevolucao());
        livroCompleto.setIsbn(dados.getIsbn());

        //Chamando a service e o metodo de la
        Livro livroCriado = livroService.criarLivro
                (livroCompleto);
        //Levando a resposta
        return ResponseEntity.ok(livroCriado);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroService.buscarTodos();
        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long livroId) {
        livroService.deletar(livroId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long livroId, @RequestBody Livro livro){
        Livro atualizado =  livroService.atualizar(livroId, livro);
        return ResponseEntity.ok(atualizado);
    }
}
