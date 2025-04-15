package com.quid.java.lambda;

import java.util.function.BiFunction;

public class LambdaStaticMethod {

    public static void main(String[] args) {
        new LambdaStaticMethod().run();
    }

    static int testMethod(int a, int b) {
        return a + b;
    }

    int testMethod2(int a, int b) {
        return a + b;
    }

    public void run() {
        // 메소드 참조
        // 메소드 참조는 메소드의 시그니처를 기반으로 메소드를 찾음 java/lang/Integer.sum(II)I,
        BiFunction<Integer, Integer, Integer> methodRef = Integer::sum;

        // 람다 표현식
        // 바이트코드를 보면 람다 표현식이 메소드 참조로 변환됨, 새 synthetic 정적 메서드 생성 후 호출됨
        BiFunction<Integer, Integer, Integer> lambda = (a, b) -> a - b;

        // 정적 메소드를 람다 표현식으로 변환
        // 새 정적 메서드 생성 X, com/quid/java/lambda/LambdaStaticMethod.testMethod(II)I 정의 되어 있는 메서드 호출됨
        BiFunction<Integer, Integer, Integer> lambdaFromMethodRef = LambdaStaticMethod::testMethod;

        // 메소드 참조를 람다 표현식으로 사용
        // 새 정적 메서드 생성 X, com/quid/java/lambda/LambdaStaticMethod.testMethod2(II)I 정의 되어 있는 메서드 호출됨
        BiFunction<Integer, Integer, Integer> lambdaFromMethodRef2 = this::testMethod2;
    }
}
