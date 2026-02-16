package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
