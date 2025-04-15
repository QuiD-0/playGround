package com.quid.java.thread;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class ThreadExample {
    public static void main(String[] args) {
        log.info("ThreadExample.main");
        ThreadExample threadExample = new ThreadExample();
        threadExample.run();
    }

    private void run() {
        MyThread myThread = new MyThread();
        log.info(String.valueOf(myThread.getState()));

        myThread.start();
        log.info(String.valueOf(myThread.getState()));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myThread.interrupt();
        log.info(String.valueOf(myThread.getState()));
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info(String.valueOf(myThread.getState()));
    }
}

@Slf4j
class MyThread extends Thread {
    @Override
    public void run() {
        log.info("ThreadExample.run");
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                log.info("ThreadExample.run InterruptedException");
                break;
            }
            log.info("ThreadExample.run running");
        }
    }
}
