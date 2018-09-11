package org.kd;

import org.kd.model.Game;
import org.kd.view.TextOutput;

public class TurnedBasedGame{

    public static void main(String[] args) {
        Game game = new Game(new TextOutput());
        game.start();
    }
}
