package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Patrocina;
import com.flordacidade.api.flor_da_cidade_api.service.PatrocinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrocina")
public class PatrocinaController {

    @Autowired
    private PatrocinaService patrocinaService;

    @GetMapping
    public List<Patrocina> findAll() {
        return patrocinaService.findAll();
    }

    @GetMapping("/{organizaId}/{equipamentoId}")
    public ResponseEntity<Patrocina> findById(
            @PathVariable Integer organizaId,
            @PathVariable Integer equipamentoId) {
        Patrocina.PatrocinaId id = new Patrocina.PatrocinaId(organizaId, equipamentoId);
        Patrocina patrocina = patrocinaService.findById(id);
        return patrocina != null ? ResponseEntity.ok(patrocina) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Patrocina save(@RequestBody Patrocina patrocina) {
        return patrocinaService.save(patrocina);
    }

    @DeleteMapping("/{organizaId}/{equipamentoId}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Integer organizaId,
            @PathVariable Integer equipamentoId) {
        Patrocina.PatrocinaId id = new Patrocina.PatrocinaId(organizaId, equipamentoId);
        patrocinaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
