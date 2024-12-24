package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Turma;
import com.flordacidade.api.flor_da_cidade_api.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> getAll() {
        return ResponseEntity.ok(turmaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        return turmaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> create(@RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Integer id, @RequestBody Turma turma) {
        try {
            return ResponseEntity.ok(turmaService.update(id, turma));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            turmaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
