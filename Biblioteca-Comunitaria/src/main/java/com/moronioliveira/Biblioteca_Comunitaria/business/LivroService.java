package com.moronioliveira.Biblioteca_Comunitaria.business;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public Livro criarLivro(Livro livro) {
        Optional<Livro> verificaIsbn = livroRepository.findByIsbn(livro.getIsbn());
        if (verificaIsbn.isPresent()) {
            throw new RuntimeException("Esse livro já tem um ISBN cadastrado");
        }
        livro.setEmprestado(false);

        return livroRepository.save(livro);
    }

    public Livro buscarPorId(Long livroId) {
        Livro livroDoBanco = livroRepository.findById(livroId)
                .orElseThrow();
        return livroDoBanco;
    }

    public List<Livro> buscarTodos() {

        return livroRepository.findAll();
    }

    public void deletar(Long livroId) {
        livroRepository.deleteById(livroId);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!!!"));

        livroExistente.setId(id);
        livroExistente.setName(livroAtualizado.getName());
        livroExistente.setIsbn(livroAtualizado.getIsbn());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setEmprestado(livroAtualizado.getEmprestado());
        livroExistente.setGenero(livroAtualizado.getGenero());
        livroExistente.setDataDevolucao(livroAtualizado.getDataDevolucao());

        return livroRepository.save(livroExistente);
    }
}
