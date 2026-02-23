package com.moronioliveira.Biblioteca_Comunitaria.business;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Emprestimo;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Usuario;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class EmprestimoService {

    private final LivroService livroService;
    private final UsuarioService usuarioService;
    private final EmprestimoRepository emprestimoRepository;

    @Transactional
    public Emprestimo realizarEmprestimo(Long livroId, Long usuarioId) {
        Livro livroDoBanco = livroService.buscarPorId(livroId);
        if (livroDoBanco.getEmprestado()) {
            throw new RuntimeException("Este livro já está emprestado");
        }
        livroDoBanco.setEmprestado(true);

        Usuario usuarioDoBanco = usuarioService.buscarPorId(usuarioId);
        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setLivro(livroDoBanco);
        novoEmprestimo.setUsuario(usuarioDoBanco);
        novoEmprestimo.setDataEmprestimo(LocalDateTime.now());

        return emprestimoRepository.save(novoEmprestimo);
    }

}
