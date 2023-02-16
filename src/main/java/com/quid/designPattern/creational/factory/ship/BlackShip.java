package com.quid.designPattern.creational.factory.ship;

import com.quid.designPattern.creational.factory.parts.Anchor;

public class BlackShip implements Ship {

    private String name;
    private String color;
    private Anchor anchor;

    public BlackShip(String name, Anchor anchor) {
        this.name = name;
        this.color = "Black";
        this.anchor = anchor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Anchor getAnchor() {
        return anchor;
    }
}
