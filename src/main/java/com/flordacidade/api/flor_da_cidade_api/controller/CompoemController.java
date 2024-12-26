package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.dto.CompoemDTO;
import com.flordacidade.api.flor_da_cidade_api.model.Compoem;
import com.flordacidade.api.flor_da_cidade_api.model.CompoemId;
import com.flordacidade.api.flor_da_cidade_api.service.CompoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compoem")
public class CompoemController {

    @Autowired
    private CompoemService compoemService;

    @GetMapping
    public ResponseEntity<List<Compoem>> findAll() {
        return ResponseEntity.ok(compoemService.findAll());
    }

    @GetMapping("/{seqPar}/{seqTur}")
    public ResponseEntity<Compoem> findById(@PathVariable Integer seqPar, @PathVariable Integer seqTur) {
        CompoemId id = new CompoemId(seqPar, seqTur);
        return compoemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Compoem> save(@RequestBody CompoemDTO dto) {
        Compoem compoem = dto.toCompoem();
        return ResponseEntity.ok(compoemService.save(compoem));
    }

    @PutMapping
    public ResponseEntity<Compoem> update(@RequestBody CompoemDTO dto) {
        Compoem compoem = dto.toCompoem();
        return ResponseEntity.ok(compoemService.update(compoem));
    }

    @DeleteMapping("/{seqPar}/{seqTur}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer seqPar, @PathVariable Integer seqTur) {
        CompoemId id = new CompoemId(seqPar, seqTur);
        compoemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
