package com.quid.designPattern.creational.factory;

import com.quid.designPattern.creational.factory.ship.Ship;
import com.quid.designPattern.creational.factory.shipFactory.BlackShipFactory;
import com.quid.designPattern.creational.factory.shipFactory.ShipFactory;
import com.quid.designPattern.creational.factory.shipFactory.WhiteShipFactory;
import org.junit.jupiter.api.Test;

public class Client {

    ShipFactory shipFactory;

    @Test
    public void factory() {
        printShip("white", "quid", "quid@mail.com");

    }

    private void printShip(String color, String name, String email) {
        switch (color) {
            case "white" -> shipFactory = new WhiteShipFactory();
            case "black" -> shipFactory = new BlackShipFactory();
            default -> throw new IllegalArgumentException("Unknown color");
        }
        Ship ship = shipFactory.orderShip(name, email);
        System.out.println(ship.getColor());
    }

}
