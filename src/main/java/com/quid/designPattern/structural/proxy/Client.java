package com.quid.designPattern.structural.proxy;

import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void proxy() {
        GameService gameServiceProxy = new GameServiceProxy();
        gameServiceProxy.startGame();
    }

}
