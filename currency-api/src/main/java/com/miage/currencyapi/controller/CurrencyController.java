package com.miage.currencyapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miage.currencyapi.dto.ConversionRequest;
import com.miage.currencyapi.dto.ConversionResponse;
import com.miage.currencyapi.service.CurrencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@Valid @RequestBody ConversionRequest request) {
        return currencyService.convert(request);
    }
}