package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.Equipamento;
import com.flordacidade.api.flor_da_cidade_api.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listarTodos() {
        return equipamentoRepository.findAll();
    }

    public Optional<Equipamento> buscarPorId(int id) {
        return equipamentoRepository.findById(id);
    }

    public Equipamento criar(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Optional<Equipamento> atualizar(int id, Equipamento equipamentoAtualizado) {
        return equipamentoRepository.findById(id)
                .map(equipamento -> {
                    equipamento.setLogradouro(equipamentoAtualizado.getLogradouro());
                    equipamento.setNumero(equipamentoAtualizado.getNumero());
                    equipamento.setCompl(equipamentoAtualizado.getCompl());
                    equipamento.setValidacao(equipamentoAtualizado.getValidacao());
                    equipamento.setDatSol(equipamentoAtualizado.getDatSol());
                    equipamento.setNome(equipamentoAtualizado.getNome());
                    equipamento.setObserv(equipamentoAtualizado.getObserv());
                    equipamento.setQtdBancas(equipamentoAtualizado.getQtdBancas());
                    equipamento.setDatVal(equipamentoAtualizado.getDatVal());
                    equipamento.setHorario(equipamentoAtualizado.getHorario());
                    equipamento.setQtdVisitas(equipamentoAtualizado.getQtdVisitas());
                    equipamento.setTipoEqu(equipamentoAtualizado.getTipoEqu());
                    equipamento.setResponsavel(equipamentoAtualizado.getResponsavel());
                    return equipamentoRepository.save(equipamento);
                });
    }

    public boolean deletar(int id) {
        return equipamentoRepository.findById(id).map(equipamento -> {
            equipamentoRepository.delete(equipamento);
            return true;
        }).orElse(false);
    }
}
