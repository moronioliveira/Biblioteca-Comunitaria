package com.moronioliveira.Biblioteca_Comunitaria.business;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmprestimoService {

    private final LivroRepository livroRepository;

    public Livro realizarEmprestimo(Livro livro){
       Livro livroDoBanco = livroRepository.findById(livro.getId()).orElseThrow();
        if (livroDoBanco.isEmprestado()){
            throw new RuntimeException("Este livro já está emprestado");
        }
        livroDoBanco.setEmprestado(true);
        return livroRepository.save(livroDoBanco);
    }
}
