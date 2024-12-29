package com.flordacidade.api.flor_da_cidade_api.repository;


import com.flordacidade.api.flor_da_cidade_api.model.ResponsavelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<ResponsavelModel, Long> {

    boolean existsByCpf(String cpf);
}
