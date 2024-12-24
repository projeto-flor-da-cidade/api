package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Ocorrer;
import com.flordacidade.api.flor_da_cidade_api.repository.OcorrerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrerService {

    @Autowired
    private OcorrerRepository repository;

    public List<Ocorrer> findAll() {
        return repository.findAll();
    }

    public Optional<Ocorrer> findById(Ocorrer.OcorrerId id) {
        return repository.findById(id);
    }

    public Ocorrer save(Ocorrer ocorrer) {
        return repository.save(ocorrer);
    }

    public void deleteById(Ocorrer.OcorrerId id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Relação Ocorrer não encontrada.");
        }
        repository.deleteById(id);
    }
}
