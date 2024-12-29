package com.flordacidade.api.flor_da_cidade_api.repository;


import com.flordacidade.api.flor_da_cidade_api.model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {

}
