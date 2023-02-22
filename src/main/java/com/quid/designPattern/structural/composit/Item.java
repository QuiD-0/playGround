package com.quid.designPattern.structural.composit;


public class Item implements Component {

    private final int price;
    private final String name;

    public Item(String name, int price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

}
