package com.quid.designPattern.structural.proxy;

public class DefaultGameService implements GameService {

    @Override
    public void startGame() {
        System.out.println("Game started");
    }
}
