package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Curso;
import com.flordacidade.api.flor_da_cidade_api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Integer id) {
        Curso curso = cursoService.findById(id);
        return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso cursoDetails) {
        Curso curso = cursoService.findById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        curso.setNomeCurso(cursoDetails.getNomeCurso());
        curso.setCargaHoraria(cursoDetails.getCargaHoraria());
        curso.setEmenta(cursoDetails.getEmenta());
        curso.setObservacao(cursoDetails.getObservacao());
        Curso updatedCurso = cursoService.save(curso);
        return ResponseEntity.ok(updatedCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Curso curso = cursoService.findById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
