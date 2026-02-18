package com.moronioliveira.Biblioteca_Comunitaria.controller;

import com.moronioliveira.Biblioteca_Comunitaria.business.EmprestimoService;
import com.moronioliveira.Biblioteca_Comunitaria.controller.dtos.EmprestimoDTO;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Emprestimo;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.LivroRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {
    private final EmprestimoService service;
    private final LivroRepository livroRepository;

    @PostMapping("/emprestar")
    public ResponseEntity<Emprestimo> criarEmprestimo(
            @Valid @RequestBody EmprestimoDTO dados){
    Emprestimo emprestimoCriado = service.realizarEmprestimo(dados.getLivroId(), dados.getUsuarioId());
    return ResponseEntity.ok(emprestimoCriado);
    }
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
        return ResponseEntity.ok(livroRepository.save(livro));
    }
}
