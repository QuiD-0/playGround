package com.quid.designPattern.structural.composit;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        Item item1 = new Item("item1", 10);
        Item item2 = new Item("item2", 20);
        Item item3 = new Item("item3", 30);
        Item item4 = new Item("item4", 40);
        Item item5 = new Item("item5", 50);

        Bag bag1 = new Bag(List.of(item1, item2));
        Bag bag2 = new Bag(List.of(item3, item4));
        Bag bag3 = new Bag(List.of(item5, bag1, bag2));

        System.out.println(bag1.getPrice());
        System.out.println(bag2.getPrice());
        System.out.println(bag3.getPrice());
    }

}
