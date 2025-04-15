package com.quid.java.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

@Slf4j
public class CompletableFutureExample {
    public static void main(String[] args) {
        System.out.println("CompletableFutureExample.main");
        CompletableFutureExample completableFutureExample = new CompletableFutureExample();
        completableFutureExample.run();
        completableFutureExample.forkJoin();
    }

    private void run() {
        log.info("CompletableFutureExample.run");
        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture.runAsync(() -> {
            System.out.println("작업 스레드: " + Thread.currentThread().getName());
            throw new RuntimeException();
        }, executorService).exceptionally(ex -> {
            System.out.println("예외 처리 스레드: " + Thread.currentThread().getName());
            return null;
        });

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.close();
    }

    private void forkJoin() {
        log.info("CompletableFutureExample.forkJoin");

        CompletableFuture[] array = IntStream.range(0, 7)
            .parallel()
            .mapToObj((i) -> CompletableFuture.supplyAsync(() -> {
                System.out.println("작업 스레드: " + Thread.currentThread().getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return i;
            }))
            .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(array)
            .thenRun(() -> {
                System.out.println("모든 작업 완료 스레드: " + Thread.currentThread().getName());
            });

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
