package com.flordacidade.api.flor_da_cidade_api.service;


import com.flordacidade.api.flor_da_cidade_api.model.EquipamentoModel;
import com.flordacidade.api.flor_da_cidade_api.repository.EquipamentoRepository;
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
