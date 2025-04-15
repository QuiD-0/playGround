package com.quid.java.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class PoolExecutorExample {
    public static void main(String[] args) {
        System.out.println("PoolExecutorExample.main");
        PoolExecutorExample poolExecutorExample = new PoolExecutorExample();
        ThreadPoolTaskExecutor executor = poolExecutorExample.init();

        poolExecutorExample.run(executor);

        poolExecutorExample.shutdown(executor);
    }

    private void run(ThreadPoolTaskExecutor executor) {
        IntStream.range(0, 10).forEach(i -> {
            executor.execute(() -> {
                System.out.println("thread name " + Thread.currentThread().getName() + " i = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    private ThreadPoolTaskExecutor init() {
        System.out.println("PoolExecutorExample.run");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 기본 스레드 풀 크기
        executor.setCorePoolSize(2);
        // 최대 스레드 풀 크기, 큐가 가득 차면 새로운 스레드를 생성
        executor.setMaxPoolSize(4);
        // 기본 스레드 풀 크기를 초과할 경우 대기열에 저장할 수 있는 최대 작업 수
        executor.setQueueCapacity(10);
        // 스레드가 유휴 상태일 때 대기하는 시간
        executor.setKeepAliveSeconds(30);
        // 스레드 풀의 이름 접두사
        executor.setThreadNamePrefix("MyThread-");
        // max pool size를 초과한 작업을 처리하는 방법
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 셧다운 시 모든 작업이 완료될 때까지 대기
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

    private void shutdown(ThreadPoolTaskExecutor executor) {
        System.out.println("PoolExecutorExample.shutdown");
        executor.shutdown();
    }
}
