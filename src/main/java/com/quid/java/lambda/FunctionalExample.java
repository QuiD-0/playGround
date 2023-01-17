package com.quid.java.lambda;


import static com.quid.java.lambda.FunctionalExample.FindMax.numbers;
import static com.quid.java.lambda.FunctionalExample.FunctionalToString.num;

import org.junit.jupiter.api.Test;

class FunctionalExample {

    @Test
    public void functional() {
        System.out.println(num.toString(numbers.max(1, 2)));
    }


    @FunctionalInterface
    interface FindMax {
        int max(int a, int b);
        FindMax numbers = Math::max;
    }

    @FunctionalInterface
    interface FunctionalToString {
        String toString(int a);
        FunctionalToString num = a -> a + " is the max";
    }

}
