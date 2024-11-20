package com.flordacidade.api.flor_da_cidade_api.service;


import com.flordacidade.api.flor_da_cidade_api.model.Organiza;
import com.flordacidade.api.flor_da_cidade_api.repository.OrganizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizaService {

    @Autowired
    private OrganizaRepository organizaRepository;

    public List<Organiza> listarTodos() {
        return organizaRepository.findAll();
    }

    public Organiza salvar(Organiza organiza) {
        return organizaRepository.save(organiza);
    }

    public void deletar(Integer id) {
        organizaRepository.deleteById(id);
    }

}
