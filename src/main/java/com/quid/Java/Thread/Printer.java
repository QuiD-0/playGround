package com.quid.Java.Thread;

import java.util.List;

public class Printer extends Thread {

    private final List<String> target;

    public Printer(List<String> target) {
        this.target = target;
    }

    public static Printer job(String... datas) {
        return new Printer(List.of(datas));
    }

    @Override
    public void run() {
        target.forEach(element -> {
            Sleep.sleep(1000L);
            System.out.printf("PRINTER NUMBER ::" + Thread.currentThread().getName());
            System.out.println(" PRINTING :: " + element);
        });
    }
}