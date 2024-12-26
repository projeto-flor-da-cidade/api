package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Participantes;
import com.flordacidade.api.flor_da_cidade_api.repository.ParticipantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantesService {

    @Autowired
    private ParticipantesRepository participantesRepository;

    public List<Participantes> findAll() {
        return participantesRepository.findAll();
    }

    public Optional<Participantes> findById(Integer id) {
        return participantesRepository.findById(id);
    }

    public Participantes save(Participantes participante) {
        return participantesRepository.save(participante);
    }

    public Participantes update(Participantes participante) {
        if (!participantesRepository.existsById(participante.getSeqPar())) {
            throw new IllegalArgumentException("Participante não encontrado com o ID: " + participante.getSeqPar());
        }
        return participantesRepository.save(participante);
    }

    public void deleteById(Integer id) {
        participantesRepository.deleteById(id);
    }
}
