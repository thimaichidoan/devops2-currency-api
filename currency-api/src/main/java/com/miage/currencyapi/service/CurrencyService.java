package com.miage.currencyapi.service;

import org.springframework.stereotype.Service;

import com.miage.currencyapi.client.ExchangeRateClient;
import com.miage.currencyapi.dto.ConversionRequest;
import com.miage.currencyapi.dto.ConversionResponse;

@Service
public class CurrencyService {

    private final ExchangeRateClient exchangeRateClient;

    public CurrencyService(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    public ConversionResponse convert(ConversionRequest request) {
        String from = request.getFrom().toUpperCase();
        String to = request.getTo().toUpperCase();

        double rate = exchangeRateClient.getExchangeRate(from, to);
        double convertedAmount = request.getAmount() * rate;

        convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        return new ConversionResponse(
                request.getAmount(),
                from,
                to,
                rate,
                convertedAmount
        );
    }
}