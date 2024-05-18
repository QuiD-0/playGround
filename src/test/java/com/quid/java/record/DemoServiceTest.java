package com.quid.java.record;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {

    @Test
    public void validTest() {
        // given
        Money money1 = new Money(BigDecimal.TEN, new Currency("USD"));
        Money money2 = new Money(BigDecimal.ONE, new Currency("USD"));
        DemoService demoService = new DemoService();

        // when
        Money money = demoService.minusMoney(money1, money2);

        // then
        assertEquals(new Money(BigDecimal.valueOf(9), new Currency("USD")), money);
    }

}