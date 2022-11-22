package com.quid.Java.Lambda;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

public class FunctionExample {

    @Test
    public void function() {
        Function<String, Integer> function = String::length;
        Function<Integer, Integer> function2 = (Integer i) -> i * 2;

        System.out.println(function.andThen(function2).apply("Hello World"));
    }
}
