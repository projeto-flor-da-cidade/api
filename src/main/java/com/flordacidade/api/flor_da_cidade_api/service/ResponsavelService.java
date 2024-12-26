package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Responsavel;
import com.flordacidade.api.flor_da_cidade_api.repository.ResponsavelRepository;
import com.flordacidade.api.flor_da_cidade_api.utils.CPFValidator;
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
        if (!CPFValidator.isValidCPF(responsavel.getDocumento())) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return responsavelRepository.save(responsavel);
    }

    public Responsavel atualizarResponsavel(Integer id, Responsavel responsavelAtualizado) {
        Optional<Responsavel> responsavelExistente = responsavelRepository.findById(id);
        if (responsavelExistente.isPresent()) {
            Responsavel responsavel = responsavelExistente.get();
            responsavel.setLogradouro(responsavelAtualizado.getLogradouro());
            responsavel.setNumero(responsavelAtualizado.getNumero());
            responsavel.setBairro(responsavelAtualizado.getBairro());
            responsavel.setDocumento(responsavelAtualizado.getDocumento());
            responsavel.setNome(responsavelAtualizado.getNome());
            responsavel.setGenero(responsavelAtualizado.getGenero());
            responsavel.setTelefone(responsavelAtualizado.getTelefone());
            responsavel.setEmail(responsavelAtualizado.getEmail());
            return salvarResponsavel(responsavel);
        } else {
            throw new RuntimeException("Responsável não encontrado com o ID: " + id);
        }
    }

    public void deletarResponsavel(Integer id) {
        responsavelRepository.deleteById(id);
    }
}
