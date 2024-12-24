package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Local;
import com.flordacidade.api.flor_da_cidade_api.model.Ocorrer;
import com.flordacidade.api.flor_da_cidade_api.model.Turma;
import com.flordacidade.api.flor_da_cidade_api.service.LocalService;
import com.flordacidade.api.flor_da_cidade_api.service.OcorrerService;
import com.flordacidade.api.flor_da_cidade_api.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ocorrer")
public class OcorrerController {

    @Autowired
    private OcorrerService service;

    @Autowired
    private LocalService localService;

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Ocorrer>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{seqLoc}/{seqTur}")
    public ResponseEntity<Ocorrer> getById(@PathVariable Integer seqLoc, @PathVariable Integer seqTur) {
        Ocorrer.OcorrerId id = new Ocorrer.OcorrerId(seqLoc, seqTur);
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ocorrer> create(@RequestParam Integer seqLoc, @RequestParam Integer seqTur) {
        Optional<Local> local = localService.findById(seqLoc);
        Optional<Turma> turma = turmaService.findById(seqTur);

        if (local.isEmpty() || turma.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Ocorrer ocorrer = new Ocorrer(local.get(), turma.get());
        return ResponseEntity.ok(service.save(ocorrer));
    }

    @DeleteMapping("/{seqLoc}/{seqTur}")
    public ResponseEntity<Void> delete(@PathVariable Integer seqLoc, @PathVariable Integer seqTur) {
        Ocorrer.OcorrerId id = new Ocorrer.OcorrerId(seqLoc, seqTur);
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
