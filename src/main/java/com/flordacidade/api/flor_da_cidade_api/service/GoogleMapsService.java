package com.flordacidade.api.flor_da_cidade_api.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapsService {

    @Value("${GOOGLE_API_KEY}")
    private String apiKey;

    public GeocodingResult[] geocode(String address) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        return GeocodingApi.geocode(context, address).await();
    }
}
