package com.miage.currencyapi.dto;

public class ConversionResponse {

    private double originalAmount;
    private String from;
    private String to;
    private double rate;
    private double convertedAmount;

    public ConversionResponse(double originalAmount, String from, String to, double rate, double convertedAmount) {
        this.originalAmount = originalAmount;
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.convertedAmount = convertedAmount;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}