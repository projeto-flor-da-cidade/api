package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Compoem;
import com.flordacidade.api.flor_da_cidade_api.model.CompoemId;
import com.flordacidade.api.flor_da_cidade_api.repository.CompoemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompoemService {

    @Autowired
    private CompoemRepository compoemRepository;

    public List<Compoem> findAll() {
        return compoemRepository.findAll();
    }

    public Optional<Compoem> findById(CompoemId id) {
        return compoemRepository.findById(id);
    }

    public Compoem save(Compoem compoem) {
        return compoemRepository.save(compoem);
    }

    public Compoem update(Compoem compoem) {
        return compoemRepository.save(compoem);
    }

    public void deleteById(CompoemId id) {
        compoemRepository.deleteById(id);
    }
}
