package com.flordacidade.api.flor_da_cidade_api.repository;

import com.flordacidade.api.flor_da_cidade_api.model.Patrocina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinaRepository extends JpaRepository<Patrocina, Patrocina.PatrocinaId> {
}
