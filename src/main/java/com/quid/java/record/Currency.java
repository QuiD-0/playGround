package com.quid.java.record;

import jakarta.validation.constraints.NotBlank;

public record Currency(@NotBlank String currency) {

    public Currency(String currency) {
        if (currency == null) {
            throw new NullPointerException("Currency cannot be null");
        }
        this.currency = currency.toUpperCase();
    }
}
