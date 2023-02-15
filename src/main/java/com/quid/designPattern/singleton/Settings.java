package com.quid.designPattern.singleton;

public class Settings {

    private Settings() {
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }

    private static class SettingsHolder {

        private static final Settings INSTANCE = new Settings();
    }
}
