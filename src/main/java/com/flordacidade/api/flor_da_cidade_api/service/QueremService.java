package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Querem;
import com.flordacidade.api.flor_da_cidade_api.model.QueremId;
import com.flordacidade.api.flor_da_cidade_api.repository.QueremRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueremService {

    @Autowired
    private QueremRepository repository;

    public List<Querem> findAll() {
        return repository.findAll();
    }

    public Querem findById(QueremId id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado."));
    }

    public Querem save(Querem querem) {
        return repository.save(querem);
    }

    public Querem update(QueremId id, Querem querem) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Registro não encontrado.");
        }
        return repository.save(querem);
    }

    public void deleteById(QueremId id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Registro não encontrado.");
        }
        repository.deleteById(id);
    }
}
