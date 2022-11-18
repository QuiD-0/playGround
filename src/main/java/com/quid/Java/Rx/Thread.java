package com.quid.Java.Rx;

import static java.lang.Thread.sleep;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.stream.IntStream;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Thread {

    private String[] strings = IntStream.range(0, 10).mapToObj(i -> "arr" + i)
        .toArray(String[]::new);

    public static void log(String msg) {
        String threadName = java.lang.Thread.currentThread().getName();
        log.info("[" + threadName + "] " + msg);
    }

    @Test
    @SneakyThrows
    public void multiThread() {
        Observable<String> source = Observable.fromArray(strings);

        source.subscribeOn(Schedulers.computation()).map(data -> "<<" + data + ">>")
            .observeOn(Schedulers.newThread()).subscribe(Thread::log);

        source.subscribeOn(Schedulers.computation()).map(data -> "##" + data + "##")
            .observeOn(Schedulers.newThread()).subscribe(Thread::log);

        sleep(5000);
    }

    @Test
    public void singleThread() {
        Observable<String> source = Observable.fromArray(strings);

        source.map(data -> "<<" + data + ">>").subscribe(Thread::log);

        source.map(data -> "##" + data + "##").subscribe(Thread::log);
    }
}
