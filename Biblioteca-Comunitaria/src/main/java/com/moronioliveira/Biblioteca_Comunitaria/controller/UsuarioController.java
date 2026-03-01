package com.moronioliveira.Biblioteca_Comunitaria.controller;

import com.moronioliveira.Biblioteca_Comunitaria.business.UsuarioService;
import com.moronioliveira.Biblioteca_Comunitaria.controller.dtos.UsuarioDTO;
import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(
            @Valid @RequestBody UsuarioDTO dados) {

        Usuario newUsuario = new Usuario();

        newUsuario.setSenha(dados.getSenha());
        newUsuario.setName(dados.getName());
        newUsuario.setEmail(dados.getEmail());
        newUsuario.setNumeroCelular(dados.getNumeroCelular());

        Usuario entryUsuario = usuarioService.criarUsuario(newUsuario);

        return ResponseEntity.ok(entryUsuario);
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }
}
