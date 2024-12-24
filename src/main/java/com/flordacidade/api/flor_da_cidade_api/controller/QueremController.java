package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Querem;
import com.flordacidade.api.flor_da_cidade_api.model.QueremId;
import com.flordacidade.api.flor_da_cidade_api.service.QueremService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("querem")
public class QueremController {

    @Autowired
    private QueremService service;

    @GetMapping
    public ResponseEntity<List<Querem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{seqInt}/{seqCurso}")
    public ResponseEntity<Querem> getById(@PathVariable Integer seqInt, @PathVariable Integer seqCurso) {
        QueremId id = new QueremId(seqInt, seqCurso);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Querem> create(@RequestBody Querem querem) {
        return ResponseEntity.ok(service.save(querem));
    }

    @PutMapping("/{seqInt}/{seqCurso}")
    public ResponseEntity<Querem> update(@PathVariable Integer seqInt, @PathVariable Integer seqCurso, @RequestBody Querem querem) {
        QueremId id = new QueremId(seqInt, seqCurso);
        return ResponseEntity.ok(service.update(id, querem));
    }

    @DeleteMapping("/{seqInt}/{seqCurso}")
    public ResponseEntity<Void> delete(@PathVariable Integer seqInt, @PathVariable Integer seqCurso) {
        QueremId id = new QueremId(seqInt, seqCurso);
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
