package com.flordacidade.api.flor_da_cidade_api.controller;



import com.flordacidade.api.flor_da_cidade_api.model.ResponsavelModel;
import com.flordacidade.api.flor_da_cidade_api.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsavel")

public class ResponsavelController {

    @Autowired
    private ResponsavelService service;

    @GetMapping
    public List<ResponsavelModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponsavelModel salvar(@RequestBody ResponsavelModel responsavel) {
        return service.saveResponsavel(responsavel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelModel> atualizar(@PathVariable Long id,
            @RequestBody ResponsavelModel responsavel) {
        try {
            return ResponseEntity.ok(service.atualizar(id, responsavel));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
