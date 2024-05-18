package com.quid.java.record;


import java.math.BigDecimal;

public record ExchangeRate(Currency from, Currency to, BigDecimal rate) {

    public ExchangeRate {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
        if (rate == null) {
            throw new IllegalArgumentException("Rate cannot be null");
        }
    }
}
