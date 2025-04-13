package com.quid.java.map;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {

    public static void main(String[] args) {
        new LinkedHashMapExample().run();
    }

    public void run() {
        var map = new LinkedHashMap<Data, Data>();
        Data data1 = new Data(1);
        Data data2 = new Data(2);
        Data data3 = new Data(3);

        map.put(data1, data1);
        map.put(data2, data2);
        map.put(data3, data3);

        System.out.println(map);

        map.forEach((k, v) ->
            System.out.println("Key: " + k + ", Value: " + v));
    }
}
