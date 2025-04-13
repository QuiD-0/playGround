package com.quid.java.map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Data {
    int num;

    public void UpdateHash(int value) {
        num = num + value;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Data data)) return false;

        return getNum() == data.getNum();
    }

    @Override
    public int hashCode() {
        return getNum() / 2;
    }

    @Override
    public String toString() {
        return "Data{" +
            "num=" + num +
            '}';
    }
}
