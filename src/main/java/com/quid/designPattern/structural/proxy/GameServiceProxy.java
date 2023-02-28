package com.quid.designPattern.structural.proxy;

public class GameServiceProxy implements GameService {

    private GameService gameService;


    @Override
    public void startGame() {
        if (this.gameService == null) {
            this.gameService = new DefaultGameService();
        }
        Long startTime = System.currentTimeMillis();
        gameService.startGame();
        Long endTime = System.currentTimeMillis();
        System.out.println("Game took " + (endTime - startTime) + "ms to start");
    }
}
