package com.quid.designPattern.structural.flyWeight;

import lombok.Getter;

@Getter
public final class Font {

    private final String family;
    private final int size;

    private Font(String family, int size) {
        this.family = family;
        this.size = size;
    }

    public static Font of(String family, int size) {
        return new Font(family, size);
    }
}
