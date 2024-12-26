package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Participantes;
import com.flordacidade.api.flor_da_cidade_api.service.ParticipantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participantes")
public class ParticipantesController {

    @Autowired
    private ParticipantesService participantesService;

    @GetMapping
    public ResponseEntity<List<Participantes>> findAll() {
        return ResponseEntity.ok(participantesService.findAll());
    }

    @GetMapping("/{seqPar}")
    public ResponseEntity<Participantes> findById(@PathVariable Integer seqPar) {
        return participantesService.findById(seqPar)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Participantes> save(@RequestBody Participantes participante) {
        Participantes savedParticipante = participantesService.save(participante);
        return ResponseEntity.ok(savedParticipante);
    }

    @PutMapping("/{seqPar}")
    public ResponseEntity<Participantes> update(@PathVariable Integer seqPar, @RequestBody Participantes participante) {
        if (!seqPar.equals(participante.getSeqPar())) {
            return ResponseEntity.badRequest().build();
        }
        Participantes updatedParticipante = participantesService.update(participante);
        return ResponseEntity.ok(updatedParticipante);
    }

    @DeleteMapping("/{seqPar}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer seqPar) {
        participantesService.deleteById(seqPar);
        return ResponseEntity.noContent().build();
    }
}
