package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Visitas;
import com.flordacidade.api.flor_da_cidade_api.service.VisitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitas")
public class VisitasController {

    @Autowired
    private VisitasService visitasService;

    @GetMapping
    public List<Visitas> listarTodas() {
        return visitasService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitas> buscarPorId(@PathVariable int id) {
        return visitasService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Visitas> criar(@RequestBody Visitas visitas) {
        Visitas novaVisita = visitasService.criar(visitas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVisita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitas> atualizar(@PathVariable int id, @RequestBody Visitas visitasAtualizada) {
        return visitasService.atualizar(id, visitasAtualizada)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        if (visitasService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
