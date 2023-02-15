package com.quid.designPattern.factory;

import com.quid.designPattern.factory.ship.Ship;
import com.quid.designPattern.factory.shipFactory.BlackShipFactory;
import com.quid.designPattern.factory.shipFactory.ShipFactory;
import com.quid.designPattern.factory.shipFactory.WhiteShipFactory;
import org.junit.jupiter.api.Test;

public class Client {

    ShipFactory shipFactory;

    @Test
    public void factory() {
        printShip(new BlackShipFactory(), "quid", "quid@mail.com");
        printShip(new WhiteShipFactory(), "quid", "quid@mail.com");
    }

    private void printShip(ShipFactory shipFactory, String name, String email) {
        this.shipFactory = shipFactory;
        Ship ship = shipFactory.orderShip(name, email);
        System.out.println(ship.getColor());
    }

}
