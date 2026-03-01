package com.moronioliveira.Biblioteca_Comunitaria.business;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Usuario;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        Optional<Usuario> usuarioDoBanco = usuarioRepository.findByEmail(usuario.getEmail());
            if (usuarioDoBanco.isPresent()){
                throw new RuntimeException("Esse usuario já existe!!!");
            }
        return usuarioRepository.save(usuario);
    }
    public Usuario buscarUsuario(Long usuarioId){
        Usuario buscandoUsuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o id: " + usuarioId));

        return usuarioRepository.save(buscandoUsuario);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }
}
