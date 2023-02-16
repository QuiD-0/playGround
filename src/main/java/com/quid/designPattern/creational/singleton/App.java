package com.quid.designPattern.creational.singleton;

import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void makeSingleton() {
        Settings settings = Settings.getInstance();
        Settings settings2 = Settings.getInstance();
        Assertions.assertEquals(settings, settings2);
    }

    @Test
    public void breakSingletonUsingReflection() throws Exception {
        Settings settings = Settings.getInstance();
        Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings settings2 = constructor.newInstance();
        Assertions.assertNotEquals(settings, settings2);
    }

    @Test
    public void javaSingleton() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
    }
}
