// src/main/java/flordacidade/Projeto_SEAU/repository/UserRepository.java

package com.flordacidade.api.flor_da_cidade_api.repository;


import com.flordacidade.api.flor_da_cidade_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Consulta opcional para buscar usuário pelo CPF
    Optional<User> findByCpf(String cpf);
}
