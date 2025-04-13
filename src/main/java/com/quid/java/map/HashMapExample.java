package com.quid.java.map;

import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {
        new HashMapExample().run();
    }

    public void run() {
        var map = new HashMap<Data, Data>();
        Data data1 = new Data(1);

        map.put(data1, data1);
        data1.UpdateHash(1);

        Data data2 = map.get(data1);
        System.out.println(data2);
        // HashMap에서 key로 사용한 객체를 찾을 수 없다.
        // 데이터는 사라지지 않지만, HashMap에서 key로 사용한 객체를 찾을 수 없다.

        data1.UpdateHash(-1);
        Data data3 = map.get(data1);
        System.out.println(data3);
        // 해시값을 되돌리면 찾을 수 있다.

    }

}
