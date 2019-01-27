package org.kd;

import org.kd.model.Game;
import org.kd.view.TextInput;
import org.kd.view.TextOutput;

public class TurnBasedGame {

    public static void main(String[] args) {
        Game game = new Game(new TextInput(),  new TextOutput());

        game.start();
    }
}
