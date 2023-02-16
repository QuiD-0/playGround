package com.quid.designPattern.creational.factory.ship;

import com.quid.designPattern.creational.factory.parts.Anchor;

public interface Ship {

    String getName();

    String getColor();

    Anchor getAnchor();
}
