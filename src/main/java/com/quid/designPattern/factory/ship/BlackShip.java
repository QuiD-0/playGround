package com.quid.designPattern.factory.ship;

public class BlackShip implements Ship {

    private String name;
    private String color;

    public BlackShip(String name) {
        this.name = name;
        this.color = "Black";
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
