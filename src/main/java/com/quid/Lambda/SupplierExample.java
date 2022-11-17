package com.quid.Lambda;

import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class SupplierExample {

    @Test
    public void supplier() {
        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());
    }
}
