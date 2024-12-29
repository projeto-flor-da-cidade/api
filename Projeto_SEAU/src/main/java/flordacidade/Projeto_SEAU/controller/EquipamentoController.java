package flordacidade.Projeto_SEAU.controller;

import flordacidade.Projeto_SEAU.model.EquipamentoModel;
import flordacidade.Projeto_SEAU.service.EquipamentoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    
    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EquipamentoModel> createEquipamento(@RequestBody EquipamentoModel equipamento) {
        try {
            EquipamentoModel savedEquipamento = service.saveEquipamento(equipamento);
            return ResponseEntity.ok(savedEquipamento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<EquipamentoModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoModel> buscarPorId(@PathVariable Long id) {
        Optional<EquipamentoModel> equipamento = service.buscarPorId(id);
        return equipamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoModel> atualizar(@PathVariable Long id, @RequestBody EquipamentoModel equipamento) {
        Optional<EquipamentoModel> equipamentoExistente = service.buscarPorId(id);
        if (!equipamentoExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipamento.setIdEqui(id.intValue());
        EquipamentoModel atualizado = service.saveEquipamento(equipamento);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}