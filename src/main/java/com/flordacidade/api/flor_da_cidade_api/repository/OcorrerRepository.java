package com.flordacidade.api.flor_da_cidade_api.repository;

import com.flordacidade.api.flor_da_cidade_api.model.Ocorrer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrerRepository extends JpaRepository<Ocorrer, Ocorrer.OcorrerId> {
}
