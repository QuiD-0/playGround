package com.quid.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample {
    private final Predicate<String> startsWithA = name -> name.startsWith("A");
    private final Predicate<String> longThanThree = name -> name.length() > 3;
    private final String[] names = {"Alice", "Bob", "Charlie", "David"};

    public static void main(String[] args) {
        System.out.println("StreamExample.main");
        StreamExample streamExample = new StreamExample();
        streamExample.run();
        streamExample.loopFusion();
        streamExample.shortCircuit();
        streamExample.lazyEvaluation();
        streamExample.sortedStream();
    }

    private void run() {
        String[] names = {"Alice", "Bob", "Charlie", "David"};

        List<String> data = Arrays.stream(names)
            .filter(startsWithA)
            .toList();
        System.out.println("data = " + data);

        long count = Arrays.stream(names)
            .filter(longThanThree)
            .count();
        System.out.println("count = " + count);
    }

    private void loopFusion() {
        System.out.println("StreamExample.loopFusion");

        List<String> data = Arrays.stream(names)
            .filter((s) -> {
                System.out.println("filter = " + s);
                return longThanThree.test(s);
            })
            .peek((s) -> System.out.println("peek = " + s))
            .toList();
    }

    private void shortCircuit() {
        System.out.println("StreamExample.shortCircuit");

        List<String> list = Arrays.stream(names)
            .filter((s) -> {
                System.out.println("filter = " + s);
                return longThanThree.test(s);
            })
            .limit(2)
            .peek((s) -> System.out.println("peek = " + s))
            .toList();
    }

    private void lazyEvaluation() {
        System.out.println("StreamExample.lazyEvaluation");

        Stream<String> data = Arrays.stream(names)
            .filter((s) -> {
                System.out.println("filter = " + s);
                return longThanThree.test(s);
            })
            .peek((s) -> System.out.println("peek = " + s));

        System.out.println("data = " + data);
        System.out.println("data = " + data.toList());
    }

    // sorted는 전체 데이터를 정렬하기 때문에 모든 데이터를 수집 후 넘어간다
    private void sortedStream() {
        System.out.println("StreamExample.sortedStream");

        List<String> data = Arrays.stream(names)
            .filter((s) -> {
                System.out.println("filter = " + s);
                return longThanThree.test(s);
            })
            .peek((s) -> System.out.println("before sort = " + s))
            .sorted()
            .peek((s) -> System.out.println("after sort = " + s))
            .filter((s) -> {
                System.out.println("filter = " + s);
                return longThanThree.test(s);
            })
            .toList();
    }
}
