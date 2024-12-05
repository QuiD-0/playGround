package com.quid.enums;

import java.util.function.BiFunction;

public enum EnumFunction {

    ADD((a, b) -> a + b, "add"),
    SUBTRACT((a, b) -> a - b, "subtract"),
    MULTIPLY((a, b) -> a * b, "multiply"),
    DIVIDE((a, b) -> a / b, "divide")
    ;

    private final BiFunction<Integer, Integer, Integer> function;
    private final String name;

    EnumFunction(BiFunction<Integer, Integer, Integer> function, String name) {
        this.function = function;
        this.name = this.name().toLowerCase();
    }

    public int apply(int a, int b) {
        return function.apply(a, b);
    }
}
