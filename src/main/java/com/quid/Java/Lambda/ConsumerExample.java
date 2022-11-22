package com.quid.Java.Lambda;

import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class ConsumerExample {

    @Test
    public void consumer() {
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.andThen((String s) -> System.out.println("and Then"+s)).accept("Hello World");
    }
}
