package com.quid.java.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void constructor() {
        assertThrows(NullPointerException.class, () -> new Currency(null));
        assertThrows(IllegalArgumentException.class, () -> new Currency(""));
        assertThrows(IllegalArgumentException.class, () -> new Currency(" "));
        assertEquals("USD", new Currency("usd").currency());
    }

    @Test
    void testCurrency() {
        assertThrows(NullPointerException.class, () -> new Currency(null));
    }

    @Test
    void testIsSameCurrency() {
        Currency currency1 = new Currency("USD");
        Currency currency2 = new Currency("USD");
        Currency currency3 = new Currency("EUR");
        assertEquals(currency1, currency2);
        assertEquals(currency1, currency2);
        assertNotEquals(currency1, currency3);
    }

}