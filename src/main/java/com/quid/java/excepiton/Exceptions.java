package com.quid.java.excepiton;

public class Exceptions {
    public static void main(String[] args) {
//        new Exceptions().run();
        new Exceptions().close();
    }

    void run() {
        try {
            throw new Exception("test");
        } catch (Exception e) {
            System.out.println("catch exception");
        } catch (Throwable t) {
            System.out.println("catch throwable");
        } finally {
            System.out.println("finally\n");
        }

        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            System.out.println("catch exception");
            throw e;
        } catch (Exception e) {
            System.out.println("catch second exception");
        } finally {
            System.out.println("finally");
        }
    }

    void close() {
        try (Close c = new Close()) {
            c.something();
            throw new Exception("test");
        } catch (Exception e) {
            System.out.println("catch exception");
        } finally {
            System.out.println("finally");
        }
    }
}

class Close implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("close");
    }

    public void something() {
        System.out.println("something");
    }
}
