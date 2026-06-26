package com.miage.currencyapi.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ExchangeRateClient {

    private final WebClient webClient;

    public ExchangeRateClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://open.er-api.com/v6")
                .build();
    }

    public double getExchangeRate(String from, String to) {
        Map<String, Object> response = webClient.get()
                .uri("/latest/" + from)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response == null || response.get("rates") == null) {
            throw new RuntimeException("Impossible de récupérer les taux de change");
        }

        Map<String, Object> rates = (Map<String, Object>) response.get("rates");

        Object rate = rates.get(to);

        if (rate == null) {
            throw new RuntimeException("Devise cible introuvable : " + to);
        }

        return Double.parseDouble(rate.toString());
    }
}