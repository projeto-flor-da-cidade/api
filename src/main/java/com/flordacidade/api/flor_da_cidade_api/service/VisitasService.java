package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Visitas;
import com.flordacidade.api.flor_da_cidade_api.repository.VisitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitasService {

    @Autowired
    private VisitasRepository visitasRepository;

    public List<Visitas> listarTodas() {
        return visitasRepository.findAll();
    }

    public Optional<Visitas> buscarPorId(int id) {
        return visitasRepository.findById(id);
    }

    public Visitas criar(Visitas visitas) {
        return visitasRepository.save(visitas);
    }

    public Optional<Visitas> atualizar(int id, Visitas visitasAtualizada) {
        return visitasRepository.findById(id)
                .map(visitas -> {
                    visitas.setDataVis(visitasAtualizada.getDataVis());
                    visitas.setObserv(visitasAtualizada.getObserv());
                    visitas.setTecnico(visitasAtualizada.getTecnico());
                    visitas.setEquipamento(visitasAtualizada.getEquipamento());
                    return visitasRepository.save(visitas);
                });
    }

    public boolean deletar(int id) {
        return visitasRepository.findById(id).map(visitas -> {
            visitasRepository.delete(visitas);
            return true;
        }).orElse(false);
    }
}
