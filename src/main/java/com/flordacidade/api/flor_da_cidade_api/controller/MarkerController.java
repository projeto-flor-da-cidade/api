package com.flordacidade.api.flor_da_cidade_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marcacoes")
public class MarkerController {

    private final List<String> marcadores = new ArrayList<>();

    @PostMapping
    public String adicionarMarcador(@RequestParam double lat, @RequestParam double lng) {
        String marcador = lat + "," + lng;
        marcadores.add(marcador);
        return "Marcador adicionado: " + marcador;
    }

    @GetMapping
    public List<String> listarMarcadores() {
        return marcadores;
    }
}
