package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Equipamento;
import com.flordacidade.api.flor_da_cidade_api.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping
    public List<Equipamento> listarTodos() {
        return equipamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable int id) {
        return equipamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipamento> criar(@RequestBody Equipamento equipamento) {
        Equipamento novoEquipamento = equipamentoService.criar(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEquipamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable int id, @RequestBody Equipamento equipamentoAtualizado) {
        return equipamentoService.atualizar(id, equipamentoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (equipamentoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/responsavel/{cpf}")
    public ResponseEntity<List<Equipamento>> buscarPorCpfResponsavel(@PathVariable String cpf) {
        List<Equipamento> equipamentos = equipamentoService.buscarPorCpfResponsavel(cpf);
        if (equipamentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipamentos);
    }
}
