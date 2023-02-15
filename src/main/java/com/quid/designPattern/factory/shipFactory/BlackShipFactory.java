package com.quid.designPattern.factory.shipFactory;

import com.quid.designPattern.factory.ship.BlackShip;
import com.quid.designPattern.factory.ship.Ship;

public class BlackShipFactory implements ShipFactory {

    @Override
    public Ship createShip(String name) {
        return new BlackShip(name);
    }


}
