package com.quid.java.thread;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {
    public static void main(String[] args) {
        System.out.println("ForkJoinExample.main");
        ForkJoinExample forkJoinExample = new ForkJoinExample();
        forkJoinExample.run();
    }

    private void run() {
        System.out.println("ForkJoinExample.run");
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            forkJoinPool.execute(() -> {
                System.out.println("작업 스레드: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        } finally {
            System.out.println("ForkJoinExample.run finally");
        }
    }
}
