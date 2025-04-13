package com.quid.java.lambda;

import java.util.function.Supplier;

public class LambdaExample {

    public static void main(String[] args) {
        new LambdaExample().run();
    }

    /**
     * 람다와 익명 클래스의 차이점
     * 람다식은 메소드의 구현부를 제공하는 것이고,
     * 익명 클래스는 클래스를 정의하는 것이다.
     *
     * 컴파일 시점에 Invokedynamic 바이트코드로 변환되고
     * 런타임 시점에 메소드가 생성된다.
     */
    public void run() {
        //람다
        Supplier<String> myFunc = () -> "람다";
        myFunc.get();
        System.out.println(myFunc.getClass());
//        INVOKEDYNAMIC get () Ljava / util / function / Supplier; [
//        // handle kind 0x6 : INVOKESTATIC
//        java / lang / invoke / LambdaMetafactory.metafactory(Ljava / lang / invoke / MethodHandles$Lookup;
//        Ljava / lang / String;
//        Ljava / lang / invoke / MethodType;
//        Ljava / lang / invoke / MethodType;
//        Ljava / lang / invoke / MethodHandle;
//        Ljava / lang / invoke / MethodType;)Ljava / lang / invoke / CallSite;
//        // arguments:
//        () Ljava / lang / Object;,
//        // handle kind 0x6 : INVOKESTATIC
//        com / quid / java / lambda / LambdaExample.lambda$run$0() Ljava / lang / String;,
//        () Ljava / lang / String;
//        ]

        //익명 클래스
        Supplier<String> myFunc2 = new Supplier<>() {
            @Override
            public String get() {
                return "익명 클래스";
            }
        };
        myFunc2.get();
        System.out.println(myFunc2.getClass());
        //  INVOKESPECIAL com/quid/java/lambda/LambdaExample$1.<init> (Lcom/quid/java/lambda/LambdaExample;)V
    }

}
