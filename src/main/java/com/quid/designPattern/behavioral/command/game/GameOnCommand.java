package com.quid.designPattern.behavioral.command.game;

public class GameOnCommand implements Runnable {

    private Game game;

    public GameOnCommand(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.on();
    }

}
