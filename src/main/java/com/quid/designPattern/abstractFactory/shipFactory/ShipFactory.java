package com.quid.designPattern.abstractFactory.shipFactory;

import com.quid.designPattern.abstractFactory.parts.Anchor;
import com.quid.designPattern.abstractFactory.parts.Wheel;
import com.quid.designPattern.abstractFactory.ship.Ship;

public interface ShipFactory {

    Wheel createWheel();

    Anchor createAnchor();

    Ship createShip(String name);
}
