package com.quid.designPattern.structural.composit;

import java.util.List;

public class Bag implements Component {

    List<Component> components;

    public Bag(List<Component> components) {
        this.components = components;
    }

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }
}
