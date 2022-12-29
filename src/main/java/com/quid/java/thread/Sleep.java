package com.quid.java.thread;

public class Sleep {

    public static void sleep(Long millis) {
        new Thread(() -> {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
    }
}