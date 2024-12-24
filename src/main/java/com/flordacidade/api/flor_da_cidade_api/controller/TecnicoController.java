package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Tecnico;
import com.flordacidade.api.flor_da_cidade_api.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public List<Tecnico> listarTodos() {
        return tecnicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> buscarPorId(@PathVariable int id) {
        return tecnicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tecnico> criar(@RequestBody Tecnico tecnico) {
        Tecnico novoTecnico = tecnicoService.criar(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTecnico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> atualizar(@PathVariable int id, @RequestBody Tecnico tecnicoAtualizado) {
        return tecnicoService.atualizar(id, tecnicoAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (tecnicoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
