package com.quid.designPattern.factory.ship;

public class WhiteShip implements Ship {

    private String name;
    private String color;

    public WhiteShip(String name) {
        this.name = name;
        this.color = "White";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColor() {
        return color;
    }
}
