package com.flordacidade.api.flor_da_cidade_api.controller;


import com.flordacidade.api.flor_da_cidade_api.model.Organiza;
import com.flordacidade.api.flor_da_cidade_api.service.OrganizaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Organiza")
public class OrganizaController {

    @Autowired
    private OrganizaService organizaService;

    // Metodo para listar todos
    @GetMapping
    public List<Organiza> listarTodos() {
        return organizaService.listarTodos();
    }

    // Metodo para adicionar nova organização
    @PostMapping
    public ResponseEntity<Organiza> adicionar(@RequestBody Organiza organiza) {
        Organiza novaOrganiza = organizaService.salvar(organiza);
        return new ResponseEntity<>(novaOrganiza, HttpStatus.CREATED);
    }
}

