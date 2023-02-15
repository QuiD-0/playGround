package com.quid.designPattern.factory.shipFactory;

import com.quid.designPattern.factory.ship.Ship;
import com.quid.designPattern.factory.ship.WhiteShip;

public class WhiteShipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new WhiteShip(name);
    }

}
