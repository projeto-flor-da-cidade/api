package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.TipoEqu;
import com.flordacidade.api.flor_da_cidade_api.service.TipoEquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipo_equ")
public class TipoEquController {

    @Autowired
    private TipoEquService tipoEquService;

    @GetMapping
    public List<TipoEqu> listarTodos() {
        return tipoEquService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<TipoEqu> buscarPorId(@PathVariable Integer id) {
        return tipoEquService.buscarPorId(id);
    }

    @PostMapping
    public TipoEqu salvar(@RequestBody TipoEqu tipoEqu) {
        return tipoEquService.salvar(tipoEqu);
    }

    @PutMapping("/{id}")
    public TipoEqu atualizar(@PathVariable Integer id, @RequestBody TipoEqu tipoEqu) {
        return tipoEquService.atualizar(id, tipoEqu);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        tipoEquService.deletar(id);
    }
}
