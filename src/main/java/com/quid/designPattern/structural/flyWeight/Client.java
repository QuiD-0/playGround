package com.quid.designPattern.structural.flyWeight;

import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void flyWeight() {
        FontFactory fontFactory = new FontFactory();
        Font font = fontFactory.getFont("Arial", 12);
        Font font2 = fontFactory.getFont("Arial", 12);
        assert font == font2;
        Character character = new Character('a', "red", font);
        Character character2 = new Character('b', "red", font);
        Character character3 = new Character('c', "red", font2);
    }

}
