package com.quid.java.record;

import java.math.BigDecimal;

public record Money(BigDecimal amount, Currency currency) {
    public Money {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
    }

    public Money(BigDecimal amount, String currency) {
        this(amount, new Currency(currency));
    }

    public Boolean isSameCurrency(Currency currency) {
        return this.currency.equals(currency);
    }

    public Money add(Money money) {
        if (!isSameCurrency(money.currency)) {
            throw new IllegalArgumentException("Cannot add money with different currency");
        }
        return new Money(amount.add(money.amount), currency);
    }

    public Money subtract(Money money) {
        if (!isSameCurrency(money.currency)) {
            throw new IllegalArgumentException("Cannot subtract money with different currency");
        }
        return new Money(amount.subtract(money.amount), currency);
    }
}
