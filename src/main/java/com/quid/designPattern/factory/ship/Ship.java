package com.quid.designPattern.factory.ship;

import com.quid.designPattern.factory.parts.Anchor;

public interface Ship {

    String getName();

    String getColor();

    Anchor getAnchor();
}
