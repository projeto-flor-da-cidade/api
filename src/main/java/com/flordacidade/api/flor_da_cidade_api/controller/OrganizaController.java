package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Organiza;
import com.flordacidade.api.flor_da_cidade_api.service.OrganizaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organiza")
public class OrganizaController {

    @Autowired
    private OrganizaService organizaService;

    @GetMapping
    public List<Organiza> listarTodas() {
        return organizaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organiza> buscarPorId(@PathVariable int id) {
        return organizaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Organiza> criar(@RequestBody Organiza organiza) {
        Organiza novaOrganizacao = organizaService.criar(organiza);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaOrganizacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organiza> atualizar(@PathVariable int id, @RequestBody Organiza organizaAtualizada) {
        return organizaService.atualizar(id, organizaAtualizada)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (organizaService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
