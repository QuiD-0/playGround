package com.quid.java.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrinterScheduler extends Thread {

    private final List<Printer> printers;
    private Thread schedulerThread;

    private PrinterScheduler(CopyOnWriteArrayList<Printer> printers) {
        this.printers = printers;
    }

    public static PrinterScheduler init(Printer printer) {
        return new PrinterScheduler(new CopyOnWriteArrayList<>() {{
            add(printer);
        }});
    }

    @Override
    public void run() {
        this.schedulerThread = Thread.currentThread();
        System.out.println("2. Searching Printer ... " + printers.size());
        while (true) {
            printers.forEach(this::start);
            System.out.println("Printer Status ... " + Thread.currentThread());

            Sleep.sleep(5000L);
            System.out.println("Printer Size ... " + printers.size());

            if (printers.size() == 0) {
                System.out.println("4. Printer is Empty ...");
                break;
            }
        }
    }

    public void start(Printer printer) {
        printer.run();
        printers.remove(printer);
    }

    public void addSchedule(Printer printer) {
        printers.add(printer);
    }

    public State state() {
        return schedulerThread.getState();
    }
}