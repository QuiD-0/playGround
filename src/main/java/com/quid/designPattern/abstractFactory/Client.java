package com.quid.designPattern.abstractFactory;

import com.quid.designPattern.abstractFactory.partsFactory.WhiteShipPartsFactory;
import com.quid.designPattern.abstractFactory.ship.Ship;
import com.quid.designPattern.abstractFactory.shipFactory.DefaultShipFactory;
import com.quid.designPattern.abstractFactory.shipFactory.ShipFactory;
import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void test() {
        ShipFactory shipFactory = new DefaultShipFactory(new WhiteShipPartsFactory());
        Ship ship = shipFactory.createShip("quid");
        System.out.println(ship.getName());
        System.out.println(ship.getAnchor().getColor());
        System.out.println(ship.getWheel().getColor());

    }

}
