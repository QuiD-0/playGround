package com.quid.designPattern.abstractFactory.partsFactory;

import com.quid.designPattern.abstractFactory.parts.Anchor;
import com.quid.designPattern.abstractFactory.parts.Wheel;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();

}
