package com.quid.designPattern.structural.bridge.champ;

import com.quid.designPattern.structural.bridge.skin.Skin;

public class Ari implements Champion {

    private Skin skin;
    private String name;

    public Ari(Skin skin, String name) {
        this.skin = skin;
        this.name = name;
    }

    @Override
    public void skillQ() {
        System.out.println(skin.getName() + " " + this.name + " skillQ");
    }

    @Override
    public void skillW() {
        System.out.println(skin.getName() + " " + this.name + " skillW");
    }

    @Override
    public void skillE() {
        System.out.println(skin.getName() + " " + this.name + " skillE");
    }

    @Override
    public void skillR() {
        System.out.println(skin.getName() + " " + this.name + " skillR");
    }

    @Override
    public void move() {
        System.out.println(skin.getName() + " " + this.name + " move");
    }
}
