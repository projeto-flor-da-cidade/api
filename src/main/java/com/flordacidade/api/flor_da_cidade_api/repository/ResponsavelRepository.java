package com.flordacidade.api.flor_da_cidade_api.repository;

import com.flordacidade.api.flor_da_cidade_api.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {
    // Métodos de consulta adicionais podem ser adicionados aqui
}
