package com.moronioliveira.Biblioteca_Comunitaria.business;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public Livro criarLivro(Livro livro){
        Optional<Livro> verificaIsbn = livroRepository.findByIsbn(livro.getIsbn());
        if (verificaIsbn.isPresent()){
            throw new RuntimeException("Esse livro já tem um ISBN cadastrado");
        } livro.setEmprestado(false);

        return livroRepository.save(livro);
    }
    public Livro buscarPorId(Long livroId){
        Livro livroDoBanco = livroRepository.findById(livroId)
                .orElseThrow();
        return livroDoBanco;
    }
}
