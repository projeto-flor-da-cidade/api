package com.flordacidade.api.flor_da_cidade_api.controller;

import com.flordacidade.api.flor_da_cidade_api.service.GoogleMapsService;
import com.google.maps.model.GeocodingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleMapsController {

    private final GoogleMapsService googleMapsService;

    public GoogleMapsController(GoogleMapsService googleMapsService) {
        this.googleMapsService = googleMapsService;
    }

    @GetMapping("/maps/geocode")
    public String geocode(@RequestParam String address) throws Exception {
        GeocodingResult[] results = googleMapsService.geocode(address);
        return results.length > 0 ? results[0].formattedAddress : "Address not found";
    }
}
