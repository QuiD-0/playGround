package com.quid.Java.RxJava;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

public class Filter {

    @Test
    public void filter() {
        Observable.just(1, 2, 3, 4, 5, 6)
            .filter(v -> v % 2 == 0)
            .subscribe(System.out::println);
    }

}
