package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Tecnico;
import com.flordacidade.api.flor_da_cidade_api.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> listarTodos() {
        return tecnicoRepository.findAll();
    }

    public Optional<Tecnico> buscarPorId(int id) {
        return tecnicoRepository.findById(id);
    }

    public Tecnico criar(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public Optional<Tecnico> atualizar(int id, Tecnico tecnicoAtualizado) {
        return tecnicoRepository.findById(id)
                .map(tecnico -> {
                    tecnico.setNome(tecnicoAtualizado.getNome());
                    return tecnicoRepository.save(tecnico);
                });
    }

    public boolean deletar(int id) {
        return tecnicoRepository.findById(id).map(tecnico -> {
            tecnicoRepository.delete(tecnico);
            return true;
        }).orElse(false);
    }
}
