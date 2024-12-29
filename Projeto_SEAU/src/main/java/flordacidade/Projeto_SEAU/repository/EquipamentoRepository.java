package flordacidade.Projeto_SEAU.repository;

import flordacidade.Projeto_SEAU.model.EquipamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoModel, Long> {

}
