package com.flordacidade.api.flor_da_cidade_api.repository;

import com.flordacidade.api.flor_da_cidade_api.model.Querem;
import com.flordacidade.api.flor_da_cidade_api.model.QueremId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueremRepository extends JpaRepository<Querem, QueremId> {
}
