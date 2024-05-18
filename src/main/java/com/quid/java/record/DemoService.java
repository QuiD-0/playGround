package com.quid.java.record;

public class DemoService {

    public Money minusMoney(Money money, Money moneyToSubtract) {
        return money.subtract(moneyToSubtract);
    }
}
