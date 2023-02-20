package com.quid.designPattern.structural.bridge;

import com.quid.designPattern.structural.bridge.champ.Ari;
import com.quid.designPattern.structural.bridge.champ.Champion;
import com.quid.designPattern.structural.bridge.skin.KDA;
import org.junit.jupiter.api.Test;

public class Client {

    @Test
    void test() {
        Champion champion = new Ari(new KDA(), "Ari");
        champion.skillQ();
        champion.skillW();
        champion.skillE();
        champion.skillR();
        champion.move();
    }

}
