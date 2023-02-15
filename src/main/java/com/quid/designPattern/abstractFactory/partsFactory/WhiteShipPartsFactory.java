package com.quid.designPattern.abstractFactory.partsFactory;

import com.quid.designPattern.abstractFactory.parts.Anchor;
import com.quid.designPattern.abstractFactory.parts.Wheel;
import com.quid.designPattern.abstractFactory.parts.WhiteAnchor;
import com.quid.designPattern.abstractFactory.parts.WhiteWheel;

public class WhiteShipPartsFactory implements ShipPartsFactory {

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
