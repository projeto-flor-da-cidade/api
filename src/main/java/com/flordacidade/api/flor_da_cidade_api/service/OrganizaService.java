package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Organiza;
import com.flordacidade.api.flor_da_cidade_api.repository.OrganizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizaService {

    @Autowired
    private OrganizaRepository organizaRepository;

    public List<Organiza> listarTodas() {
        return organizaRepository.findAll();
    }

    public Optional<Organiza> buscarPorId(int id) {
        return organizaRepository.findById(id);
    }

    public Organiza criar(Organiza organiza) {
        return organizaRepository.save(organiza);
    }

    public Optional<Organiza> atualizar(int id, Organiza organizaAtualizada) {
        return organizaRepository.findById(id)
                .map(organiza -> {
                    organiza.setNome(organizaAtualizada.getNome());
                    organiza.setEndereco(organizaAtualizada.getEndereco());
                    return organizaRepository.save(organiza);
                });
    }

    public boolean deletar(int id) {
        return organizaRepository.findById(id).map(organiza -> {
            organizaRepository.delete(organiza);
            return true;
        }).orElse(false);
    }
}
