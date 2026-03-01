package com.moronioliveira.Biblioteca_Comunitaria.business;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Emprestimo;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Usuario;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmprestimoService {

    private final LivroService livroService;
    private final UsuarioService usuarioService;
    private final EmprestimoRepository emprestimoRepository;

    //Create
    @Transactional
    public Emprestimo realizarEmprestimo(Emprestimo emprestimo) {

        Livro livroDoBanco = livroService.buscarPorId(emprestimo.getLivro().getId());

        if (livroDoBanco.getEmprestado()) {
            throw new RuntimeException("Este livro já está emprestado");
        }
        livroDoBanco.setEmprestado(true);

        livroService.atualizar(livroDoBanco.getId(), livroDoBanco);

        Usuario usuarioDoBanco = usuarioService.buscarUsuario(emprestimo.getUsuario().getId());

        emprestimo.setLivro(livroDoBanco);
        emprestimo.setUsuario(usuarioDoBanco);
        emprestimo.setDataEmprestimo(LocalDateTime.now());

        return emprestimoRepository.save(emprestimo);

    }
    public List<Emprestimo> buscarEmprestimos(){
        return emprestimoRepository.findAll();
    }

    public void deletar(Long emprestimoId){
        emprestimoRepository.deleteById(emprestimoId);
    }

}
