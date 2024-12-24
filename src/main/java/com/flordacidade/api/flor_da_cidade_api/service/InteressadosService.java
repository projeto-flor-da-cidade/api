package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Interessados;
import com.flordacidade.api.flor_da_cidade_api.repository.InteressadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteressadosService {

    @Autowired
    private InteressadosRepository repository;

    public List<Interessados> findAll() {
        return repository.findAll();
    }

    public Optional<Interessados> findById(Integer id) {
        return repository.findById(id);
    }

    public Interessados save(Interessados interessado) {
        return repository.save(interessado);
    }

    public Interessados update(Integer id, Interessados interessado) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNome(interessado.getNome());
                    existing.setSeqOrga(interessado.getSeqOrga());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Interessado não encontrado"));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
