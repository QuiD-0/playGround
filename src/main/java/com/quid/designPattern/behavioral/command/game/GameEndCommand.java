package com.quid.designPattern.behavioral.command.game;

public class GameEndCommand implements Runnable {

    private Game game;

    public GameEndCommand(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.off();
    }

}
