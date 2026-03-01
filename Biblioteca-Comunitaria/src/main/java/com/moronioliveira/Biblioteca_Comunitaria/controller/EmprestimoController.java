package com.moronioliveira.Biblioteca_Comunitaria.controller;

import com.moronioliveira.Biblioteca_Comunitaria.business.EmprestimoService;
import com.moronioliveira.Biblioteca_Comunitaria.controller.dtos.EmprestimoDTO;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Emprestimo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/emprestimos")

public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Emprestimo> criarEmprestimo(
            @Valid @RequestBody EmprestimoDTO dados){

       Emprestimo emprestimoCriado = new Emprestimo();

       emprestimoCriado.setDataEmprestimo(dados.getDataEmprestimo());
       emprestimoCriado.setLivro(dados.getLivro());
       emprestimoCriado.setUsuario(dados.getUsuario());
       emprestimoCriado.setDataDevolucao(dados.getDataDevolucao());

       Emprestimo novoEmprestimo = emprestimoService.realizarEmprestimo(emprestimoCriado);
    
       return ResponseEntity.ok(novoEmprestimo);
    }
    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarEmprestimos(){
        List<Emprestimo> listaEmprestimos = emprestimoService.buscarEmprestimos();
        return ResponseEntity.ok(listaEmprestimos);
    }

    @DeleteMapping("/{emprestimoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long emprestimoId){
        emprestimoService.deletar(emprestimoId);
        return ResponseEntity.noContent().build();
    }
}
