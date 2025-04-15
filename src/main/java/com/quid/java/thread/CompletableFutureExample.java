package com.quid.java.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class CompletableFutureExample {
    public static void main(String[] args) {
        System.out.println("CompletableFutureExample.main");
        CompletableFutureExample completableFutureExample = new CompletableFutureExample();
        completableFutureExample.run();
        completableFutureExample.exceptionally();
    }

    private void run() {
        log.info("CompletableFutureExample.run");
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        CompletableFuture.runAsync(() -> {
            System.out.println("작업 스레드: " + Thread.currentThread().getName());
            throw new RuntimeException();
        }, executorService).exceptionally(ex -> {
            System.out.println("예외 처리 스레드: " + Thread.currentThread().getName());
            return null;
        }).thenRun(() -> {
            System.out.println("모든 작업 완료 스레드: " + Thread.currentThread().getName());
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.close();
    }

    private void exceptionally() {
        log.info("CompletableFutureExample.forkJoin");
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // exceptionally는 기본적으로 예외가 발생한 스레드에서 실행된다.
        CompletableFuture[] array = IntStream.range(0, 20)
            .parallel()
            .mapToObj((i) -> CompletableFuture.supplyAsync(() -> {
                    System.out.println(i + " 작업 스레드: " + Thread.currentThread().getName());
                    try {
                        Random random = new Random();
                        int randomInt = random.nextInt(10);
                        Thread.sleep(1000 * randomInt);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (i == 5) {
                        throw new RuntimeException("예외 발생" + i);
                    }
                    return i;
                }).exceptionally((ex) -> {
                    System.out.println("예외 처리 스레드: " + Thread.currentThread().getName());
                    System.out.println("예외 처리: " + ex.getMessage());
                    return null;
                })
            )
            .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(array)
            .thenRun(() -> {
                System.out.println("모든 작업 완료 스레드: " + Thread.currentThread().getName());
                countDownLatch.countDown();
            });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
