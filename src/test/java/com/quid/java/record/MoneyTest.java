package com.quid.java.record;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void testMoney() {
        assertThrows(IllegalArgumentException.class, () -> new Money(null, "USD"));
    }

    @Test
    void testIsSameCurrency() {
        Money money1 = new Money(new BigDecimal(100), "USD");
        Money money2 = new Money(new BigDecimal(100), "USD");
        Money money3 = new Money(new BigDecimal(100), "EUR");
        assertTrue(money1.isSameCurrency(money2.currency()));
        assertFalse(money1.isSameCurrency(money3.currency()));
    }

    @Test
    void add() {
        Money money1 = new Money(new BigDecimal(100), "USD");
        Money money2 = new Money(new BigDecimal(100), "USD");
        Money money3 = new Money(new BigDecimal(100), "EUR");
        Money result = money1.add(money2);
        assertEquals(new Money(new BigDecimal(200), "USD"), result);
        assertThrows(IllegalArgumentException.class, () -> money1.add(money3));
    }

}