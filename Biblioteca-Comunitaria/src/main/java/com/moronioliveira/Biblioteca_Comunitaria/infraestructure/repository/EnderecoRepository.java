package com.moronioliveira.Biblioteca_Comunitaria.infraestructure.repository;

import com.moronioliveira.Biblioteca_Comunitaria.infraestructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
}
