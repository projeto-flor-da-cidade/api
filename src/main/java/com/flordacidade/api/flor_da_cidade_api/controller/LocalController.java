package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Local;
import com.flordacidade.api.flor_da_cidade_api.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<Local>> getAll() {
        return ResponseEntity.ok(localService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getById(@PathVariable Integer id) {
        return localService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Local> create(@RequestBody Local local) {
        return ResponseEntity.ok(localService.save(local));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> update(@PathVariable Integer id, @RequestBody Local local) {
        try {
            return ResponseEntity.ok(localService.update(id, local));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            localService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
