package flordacidade.Projeto_SEAU.repository;

import flordacidade.Projeto_SEAU.model.ResponsavelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<ResponsavelModel, Long> {

    boolean existsByCpf(String cpf);
}
