package com.quid.Rx.basic;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Test;

public class ObservableStudy {

    @Test
    public void Flowable(){
        Flowable.just("Hello world").subscribe(System.out::println);
    }


    @Test
    public void ObservableTest() {
        Observable<String> obs = Observable.just("Hello", "RxJava");
        obs.subscribe(System.out::println);
    }

    @Test
    public void fromArray() {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }

    @Test
    public void observableToSingle() {
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
            .subscribe(System.out::println);
    }

    @Test
    public void single() {
        Observable.empty()
            .single("default value")
            .subscribe(System.out::println);
    }
}
