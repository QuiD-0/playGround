package com.quid.designPattern.abstractFactory.shipFactory;

import com.quid.designPattern.abstractFactory.parts.Anchor;
import com.quid.designPattern.abstractFactory.parts.Wheel;
import com.quid.designPattern.abstractFactory.partsFactory.ShipPartsFactory;
import com.quid.designPattern.abstractFactory.ship.Ship;
import com.quid.designPattern.abstractFactory.ship.WhiteShip;

public class DefaultShipFactory implements ShipFactory {

    private final ShipPartsFactory shipPartsFactory;

    public DefaultShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Wheel createWheel() {
        return shipPartsFactory.createWheel();
    }

    @Override
    public Anchor createAnchor() {
        return shipPartsFactory.createAnchor();
    }

    @Override
    public Ship createShip(String name) {
        return new WhiteShip(createWheel(), createAnchor(), name);
    }
}
