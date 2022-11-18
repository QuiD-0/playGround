package com.quid.Java.Rx;

import static java.lang.Thread.sleep;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class HotCold {

    @Test
    @SneakyThrows
    public void hotObservable() {

        ConnectableObservable observable = Observable.interval(1, TimeUnit.SECONDS)
            .publish();

        observable.connect();
        observable.subscribe(e -> System.out.println("Observer 1 : " + e));
        sleep(5000);
        observable.subscribe(e -> System.out.println("Observer 2 : " + e));
        sleep(5000);
    }

    @Test
    @SneakyThrows
    public void coldObservable() {
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(e -> System.out.println("Observer 1 : " + e));
        sleep(5000);
        observable.subscribe(e -> System.out.println("Observer 2 : " + e));
        sleep(5000);
    }

}
