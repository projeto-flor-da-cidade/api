package flordacidade.Projeto_SEAU.service;

import flordacidade.Projeto_SEAU.model.EquipamentoModel;
import flordacidade.Projeto_SEAU.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public Optional<EquipamentoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    public List<EquipamentoModel> listarTodos() {
        return repository.findAll();
    }

    public EquipamentoModel saveEquipamento(EquipamentoModel equipamento) {
        return repository.save(equipamento);
    }
}
