package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Turma;
import com.flordacidade.api.flor_da_cidade_api.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(Integer id) {
        return turmaRepository.findById(id);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma update(Integer id, Turma turma) {
        if (!turmaRepository.existsById(id)) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }
        turma.setSeqTur(id);
        return turmaRepository.save(turma);
    }

    public void deleteById(Integer id) {
        if (!turmaRepository.existsById(id)) {
            throw new IllegalArgumentException("Turma não encontrada.");
        }
        turmaRepository.deleteById(id);
    }
}
