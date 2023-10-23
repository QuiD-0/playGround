package com.quid.designPattern.behavioral.command;

import com.quid.designPattern.behavioral.command.game.Game;
import com.quid.designPattern.behavioral.command.game.GameOnCommand;
import com.quid.designPattern.behavioral.command.light.Light;
import com.quid.designPattern.behavioral.command.light.LightOnCommand;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void appCommand() {
        Button button = new Button(new GameOnCommand(new Game()));
        button.press();

        Button button2 = new Button(new LightOnCommand(new Light()));
        button2.press();
    }
}
