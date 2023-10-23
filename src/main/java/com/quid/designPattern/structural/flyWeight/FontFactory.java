package com.quid.designPattern.structural.flyWeight;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    private Map<String, Font> fonts = new HashMap<>();

    public Font getFont(String family, int size) {
        String key = family + size;
        return fonts.computeIfAbsent(key, k -> Font.of(family, size));
    }
}

