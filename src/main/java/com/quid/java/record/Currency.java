package com.quid.java.record;

public record Currency(String currency) {

    public Currency(String currency) {
        if (currency == null) {
            throw new NullPointerException("Currency cannot be null");
        }
        if (currency.isBlank()) {
            throw new IllegalArgumentException("Currency cannot be blank");
        }
        this.currency = currency.toUpperCase();
    }
}
