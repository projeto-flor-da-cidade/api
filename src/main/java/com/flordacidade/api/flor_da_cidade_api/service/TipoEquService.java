package com.flordacidade.api.flor_da_cidade_api.service;

import com.flordacidade.api.flor_da_cidade_api.model.TipoEqu;
import com.flordacidade.api.flor_da_cidade_api.repository.TipoEquRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEquService {

    @Autowired
    private TipoEquRepository tipoEquRepository;

    public List<TipoEqu> listarTodos() {
        return tipoEquRepository.findAll();
    }

    public Optional<TipoEqu> buscarPorId(Integer id) {
        return tipoEquRepository.findById(id);
    }

    public TipoEqu salvar(TipoEqu tipoEqu) {
        return tipoEquRepository.save(tipoEqu);
    }

    public TipoEqu atualizar(Integer id, TipoEqu tipoEquAtualizado) {
        return tipoEquRepository.findById(id)
                .map(tipoEqu -> {
                    tipoEqu.setDescrTipoEqu(tipoEquAtualizado.getDescrTipoEqu());
                    return tipoEquRepository.save(tipoEqu);
                })
                .orElseThrow(() -> new IllegalArgumentException("TipoEquipamento não encontrado para o ID: " + id));
    }

    public void deletar(Integer id) {
        tipoEquRepository.deleteById(id);
    }
}
