package com.quid.java.record;

public record Exchanger(Money money, ExchangeRate exchangeRate) {

    public Exchanger {
        if (money == null) {
            throw new IllegalArgumentException("Money cannot be null");
        }
        if (exchangeRate == null) {
            throw new IllegalArgumentException("Exchange rate cannot be null");
        }
    }
}
