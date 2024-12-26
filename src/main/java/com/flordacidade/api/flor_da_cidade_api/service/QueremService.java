package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Curso;
import com.flordacidade.api.flor_da_cidade_api.model.Interessados;
import com.flordacidade.api.flor_da_cidade_api.model.Querem;
import com.flordacidade.api.flor_da_cidade_api.model.QueremId;
import com.flordacidade.api.flor_da_cidade_api.repository.CursoRepository;
import com.flordacidade.api.flor_da_cidade_api.repository.InteressadosRepository;
import com.flordacidade.api.flor_da_cidade_api.repository.QueremRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QueremService {

    @Autowired
    private QueremRepository queremRepository;

    @Autowired
    private InteressadosRepository interessadosRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Querem> findAll() {
        return queremRepository.findAll();
    }

    public Optional<Querem> findById(QueremId id) {
        return queremRepository.findById(id);
    }

    public Querem save(Querem querem) {
        // Validar se Interessados e Curso existem antes de salvar
        Interessados interessado = interessadosRepository.findById(querem.getId().getSeqInt())
                .orElseThrow(() -> new IllegalArgumentException("Interessado não encontrado com ID: " + querem.getId().getSeqInt()));

        Curso curso = cursoRepository.findById(querem.getId().getSeqCurso())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com ID: " + querem.getId().getSeqCurso()));

        querem.setInteressado(interessado);
        querem.setCurso(curso);

        return queremRepository.save(querem);
    }


    public Querem update(Querem querem) {
        // Certifique-se de que a relação existe antes de atualizar
        QueremId id = querem.getId();
        if (!queremRepository.existsById(id)) {
            throw new IllegalArgumentException("A relação Querem não existe para os IDs fornecidos: " + id);
        }
        return queremRepository.save(querem);
    }

    public void deleteById(QueremId id) {
        queremRepository.deleteById(id);
    }
}
