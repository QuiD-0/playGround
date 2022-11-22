package com.quid.Java.Lambda;

import org.junit.jupiter.api.Test;

class Functional {

    @Test
    public void functional() {
        FunctionalMax lambdaFunction = (int a, int b) -> a > b ? a : b;
        FunctionalToString functionalToString = (int a) -> String.valueOf(a);

        int max = lambdaFunction.max(10, 20);
        String str = functionalToString.toString(max);
        System.out.println(str);
    }


    @FunctionalInterface
    interface FunctionalMax {
        int max(int a, int b);
    }

    @FunctionalInterface
    interface FunctionalToString {
        String toString(int a);
    }

}
