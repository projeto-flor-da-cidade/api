package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Patrocina;
import com.flordacidade.api.flor_da_cidade_api.repository.PatrocinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatrocinaService {

    @Autowired
    private PatrocinaRepository patrocinaRepository;

    public List<Patrocina> findAll() {
        return patrocinaRepository.findAll();
    }

    public Patrocina findById(Patrocina.PatrocinaId id) {
        return patrocinaRepository.findById(id).orElse(null);
    }

    public Patrocina save(Patrocina patrocina) {
        return patrocinaRepository.save(patrocina);
    }

    public void deleteById(Patrocina.PatrocinaId id) {
        patrocinaRepository.deleteById(id);
    }
}
