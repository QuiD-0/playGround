package com.quid.designPattern.abstractFactory.ship;

import com.quid.designPattern.abstractFactory.parts.Anchor;
import com.quid.designPattern.abstractFactory.parts.Wheel;

public class WhiteShip implements Ship {

    private Wheel wheel;
    private Anchor anchor;
    private String name;

    public WhiteShip(Wheel wheel, Anchor anchor, String name) {
        this.wheel = wheel;
        this.anchor = anchor;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Anchor getAnchor() {
        return anchor;
    }

    @Override
    public Wheel getWheel() {
        return wheel;
    }
}
