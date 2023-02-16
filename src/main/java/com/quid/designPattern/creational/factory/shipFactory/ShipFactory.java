package com.quid.designPattern.creational.factory.shipFactory;


import com.quid.designPattern.creational.factory.ship.Ship;

public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareShip(name);
        Ship ship = createShip(name);
        sendEmail(email, ship);
        return ship;
    }

    private void sendEmail(String email, Ship ship) {
        System.out.println("Sending email to " + email + " about " + ship);
    }

    Ship createShip(String name);

    private void prepareShip(String name) {
        System.out.println("Preparing " + name);
    }

    private void validate(String name, String email) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
    }

}
