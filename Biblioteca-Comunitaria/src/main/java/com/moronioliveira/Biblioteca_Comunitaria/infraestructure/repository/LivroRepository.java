package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);
}
