package com.quid.designPattern.creational.factory.shipFactory;

import com.quid.designPattern.creational.factory.parts.WhiteAnchor;
import com.quid.designPattern.creational.factory.ship.Ship;
import com.quid.designPattern.creational.factory.ship.WhiteShip;

public class WhiteShipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new WhiteShip(name, new WhiteAnchor());
    }

}
