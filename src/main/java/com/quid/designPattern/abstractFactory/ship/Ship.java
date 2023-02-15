package com.quid.designPattern.abstractFactory.ship;

import com.quid.designPattern.abstractFactory.parts.Anchor;
import com.quid.designPattern.abstractFactory.parts.Wheel;

public interface Ship {

    String getName();

    Anchor getAnchor();

    Wheel getWheel();

}
