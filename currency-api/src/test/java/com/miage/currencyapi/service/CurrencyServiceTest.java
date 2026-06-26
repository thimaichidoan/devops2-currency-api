package com.miage.currencyapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.miage.currencyapi.client.ExchangeRateClient;
import com.miage.currencyapi.dto.ConversionRequest;
import com.miage.currencyapi.dto.ConversionResponse;

class CurrencyServiceTest {

    @Test
    void shouldConvertCurrency() {

        ExchangeRateClient client = mock(ExchangeRateClient.class);

        when(client.getExchangeRate("EUR", "USD"))
                .thenReturn(1.2);

        CurrencyService service = new CurrencyService(client);

        ConversionRequest request = new ConversionRequest();
        request.setAmount(100.0);
        request.setFrom("EUR");
        request.setTo("USD");

        ConversionResponse response = service.convert(request);

        assertEquals(120.0, response.getConvertedAmount());
        assertEquals("EUR", response.getFrom());
        assertEquals("USD", response.getTo());
    }

    @Test
    void shouldRoundToTwoDecimals() {

        ExchangeRateClient client = mock(ExchangeRateClient.class);

        when(client.getExchangeRate("EUR", "USD"))
                .thenReturn(1.136188);

        CurrencyService service = new CurrencyService(client);

        ConversionRequest request = new ConversionRequest();
        request.setAmount(100.0);
        request.setFrom("EUR");
        request.setTo("USD");

        ConversionResponse response = service.convert(request);

        assertEquals(113.62, response.getConvertedAmount());
    }
}