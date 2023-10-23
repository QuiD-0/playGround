package com.quid.designPattern.behavioral.command.light;

public class LightOnCommand implements Runnable {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        light.on();
    }

}
