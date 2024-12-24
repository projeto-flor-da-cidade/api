package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Responsavel;
import com.flordacidade.api.flor_da_cidade_api.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public List<Responsavel> listarResponsaveis() {
        return responsavelRepository.findAll();
    }

    public Optional<Responsavel> buscarPorId(Integer id) {
        return responsavelRepository.findById(id);
    }

    public Responsavel salvarResponsavel(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public void deletarResponsavel(Integer id) {
        responsavelRepository.deleteById(id);
    }
}
