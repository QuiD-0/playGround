package com.quid.java.virtualThread;

import static java.lang.Thread.sleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VThread {

    public static void main(String[] args) {
        System.out.println("---------");
        try (ExecutorService e = Executors.newVirtualThreadPerTaskExecutor()) {
            e.submit(getRunnable("1"));
            e.submit(getRunnable("2"));
        }
        System.out.println("---------");
    }

    private static Runnable getRunnable(String number) {
        return () -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(number);
        };
    }

}
