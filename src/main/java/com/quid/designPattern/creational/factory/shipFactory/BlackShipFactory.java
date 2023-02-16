package com.quid.designPattern.creational.factory.shipFactory;

import com.quid.designPattern.creational.factory.parts.BlackAnchor;
import com.quid.designPattern.creational.factory.ship.BlackShip;
import com.quid.designPattern.creational.factory.ship.Ship;

public class BlackShipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new BlackShip(name, new BlackAnchor());
    }


}
