package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Interessados;
import com.flordacidade.api.flor_da_cidade_api.service.InteressadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interessados")
public class InteressadosController {

    @Autowired
    private InteressadosService service;

    @GetMapping
    public List<Interessados> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interessados> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Interessados save(@RequestBody Interessados interessado) {
        return service.save(interessado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interessados> update(@PathVariable Integer id, @RequestBody Interessados interessado) {
        try {
            return ResponseEntity.ok(service.update(id, interessado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
