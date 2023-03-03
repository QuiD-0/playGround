package com.quid.designPattern.behavioral.command;

public class Button {

    private Runnable command;

    public Button(Runnable command) {
        this.command = command;
    }

    public void press() {
        command.run();
    }

}
