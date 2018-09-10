package org.kd.model;

import org.kd.model.creational_patterns.UnitsFactory;
import org.kd.model.game_objects.Peasant;

public class BoardBuilder {

    private static Board board;

    public BoardBuilder(){
        board = new Board();
    }

    public BoardBuilder createStandardBoard(){
        board.peasants = new UnitsFactory().createPeasantsOnDefaultPositions(Player.BLUE, 1, 0);
        board.peasants = new UnitsFactory().createPeasantsOnDefaultPositions(Player.RED, 1, 0);
        return this;
    }

    public BoardBuilder withPeasants(Player side, int amount){
        board.peasants.addAll(new UnitsFactory().createPeasantsOnDefaultPositions(side, amount - 1, 1));
        return this;
    }



}
