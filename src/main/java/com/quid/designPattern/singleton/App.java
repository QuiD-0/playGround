package com.quid.designPattern.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void test() {
        Settings settings = Settings.getInstance();
        Settings settings2 = Settings.getInstance();
        Assertions.assertEquals(settings, settings2);
    }

}
