package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Querem;
import com.flordacidade.api.flor_da_cidade_api.model.QueremId;
import com.flordacidade.api.flor_da_cidade_api.service.QueremService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/querem")
public class QueremController {

    @Autowired
    private QueremService queremService;

    @GetMapping
    public ResponseEntity<List<Querem>> findAll() {
        return ResponseEntity.ok(queremService.findAll());
    }

    @GetMapping("/{seqInt}/{seqCurso}")
    public ResponseEntity<Querem> findById(@PathVariable int seqInt, @PathVariable int seqCurso) {
        QueremId id = new QueremId(seqInt, seqCurso);
        return queremService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Querem> save(@RequestBody Querem querem) {
        Querem savedQuerem = queremService.save(querem);
        return ResponseEntity.ok(savedQuerem);
    }

    @PutMapping("/{seqInt}/{seqCurso}")
    public ResponseEntity<Querem> update(@PathVariable int seqInt, @PathVariable int seqCurso, @RequestBody Querem querem) {
        QueremId id = new QueremId(seqInt, seqCurso);
        if (!id.equals(querem.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Querem updatedQuerem = queremService.update(querem);
        return ResponseEntity.ok(updatedQuerem);
    }

    @DeleteMapping("/{seqInt}/{seqCurso}")
    public ResponseEntity<Void> deleteById(@PathVariable int seqInt, @PathVariable int seqCurso) {
        QueremId id = new QueremId(seqInt, seqCurso);
        queremService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
