package com.flordacidade.api.flor_da_cidade_api.repository;

import com.flordacidade.api.flor_da_cidade_api.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

    @Query("SELECT e FROM Equipamento e WHERE e.responsavel.cpf = :cpf")
    List<Equipamento> findByResponsavelCpf(String cpf);
}
