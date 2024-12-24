package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.model.Responsavel;
import com.flordacidade.api.flor_da_cidade_api.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public List<Responsavel> listarResponsaveis() {
        return responsavelService.listarResponsaveis();
    }

    @GetMapping("/{id}")
    public Optional<Responsavel> buscarPorId(@PathVariable Integer id) {
        return responsavelService.buscarPorId(id);
    }

    @PostMapping
    public Responsavel salvarResponsavel(@RequestBody Responsavel responsavel) {
        return responsavelService.salvarResponsavel(responsavel);
    }

    @PutMapping("/{id}")
    public Responsavel atualizarResponsavel(@PathVariable Integer id, @RequestBody Responsavel responsavelAtualizado) {
        Optional<Responsavel> responsavelExistente = responsavelService.buscarPorId(id);
        if (responsavelExistente.isPresent()) {
            Responsavel responsavel = responsavelExistente.get();
            responsavel.setLogradouro(responsavelAtualizado.getLogradouro());
            responsavel.setNumero(responsavelAtualizado.getNumero());
            responsavel.setBairro(responsavelAtualizado.getBairro());
            responsavel.setDocumento(responsavelAtualizado.getDocumento());
            responsavel.setNome(responsavelAtualizado.getNome());
            responsavel.setGenero(responsavelAtualizado.getGenero());
            responsavel.setTelefone(responsavelAtualizado.getTelefone());
            responsavel.setEmail(responsavelAtualizado.getEmail());
            return responsavelService.salvarResponsavel(responsavel);
        } else {
            throw new RuntimeException("Responsável não encontrado com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarResponsavel(@PathVariable Integer id) {
        responsavelService.deletarResponsavel(id);
    }
}