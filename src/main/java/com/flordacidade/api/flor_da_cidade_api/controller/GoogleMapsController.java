package com.flordacidade.api.flor_da_cidade_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleMapsController {

    @Value("${google.api.key}")
    private String apiKey;

    @GetMapping("/mapa-estatico")
    public String gerarMapa(@RequestParam String marcadores) {
        String baseUrl = "https://maps.googleapis.com/maps/api/staticmap";
        String tamanho = "600x400"; // Dimensão da imagem
        String url = String.format("%s?size=%s&markers=%s&key=%s", baseUrl, tamanho, marcadores, apiKey);
        return url;
    }
}
