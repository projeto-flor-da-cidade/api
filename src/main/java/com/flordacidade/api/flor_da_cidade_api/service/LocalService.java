package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Local;
import com.flordacidade.api.flor_da_cidade_api.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public List<Local> findAll() {
        return localRepository.findAll();
    }

    public Optional<Local> findById(Integer id) {
        return localRepository.findById(id);
    }

    public Local save(Local local) {
        return localRepository.save(local);
    }

    public Local update(Integer id, Local local) {
        if (!localRepository.existsById(id)) {
            throw new IllegalArgumentException("Local não encontrado.");
        }
        local.setId(id);
        return localRepository.save(local);
    }

    public void deleteById(Integer id) {
        if (!localRepository.existsById(id)) {
            throw new IllegalArgumentException("Local não encontrado.");
        }
        localRepository.deleteById(id);
    }
}
