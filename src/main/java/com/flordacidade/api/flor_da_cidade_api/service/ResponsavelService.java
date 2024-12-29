package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.ResponsavelModel;
import com.flordacidade.api.flor_da_cidade_api.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository repository;

    public boolean isCpfValid(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}"))
            return false;

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++)
                sum += (cpf.charAt(i) - '0') * (10 - i);
            int firstDigit = 11 - (sum % 11);
            if (firstDigit >= 10)
                firstDigit = 0;

            sum = 0;
            for (int i = 0; i < 10; i++)
                sum += (cpf.charAt(i) - '0') * (11 - i);
            int secondDigit = 11 - (sum % 11);
            if (secondDigit >= 10)
                secondDigit = 0;

            return cpf.charAt(9) - '0' == firstDigit && cpf.charAt(10) - '0' == secondDigit;
        } catch (InputMismatchException e) {
            return false;
        }
    }

    public ResponsavelModel saveResponsavel(ResponsavelModel responsavel) {
        if (!isCpfValid(responsavel.getCpf())) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if (repository.existsByCpf(responsavel.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        return repository.save(responsavel);
    }

    public List<ResponsavelModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ResponsavelModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ResponsavelModel atualizar(Long id, ResponsavelModel responsavelAtualizado) {
        ResponsavelModel responsavel = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado."));
        responsavel.setLogradouro(responsavelAtualizado.getLogradouro());
        responsavel.setNumero(responsavelAtualizado.getNumero());
        responsavel.setBairro(responsavelAtualizado.getBairro());
        responsavel.setNome(responsavelAtualizado.getNome());
        responsavel.setTelefone(responsavelAtualizado.getTelefone());
        responsavel.setEmail(responsavelAtualizado.getEmail());
        responsavel.setCpf(responsavelAtualizado.getCpf());
        return repository.save(responsavel);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
