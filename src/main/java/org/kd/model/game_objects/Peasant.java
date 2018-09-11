package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class Peasant extends CivilianUnit {

    private static int redPeasantsAmount = 0;
    private static int bluePeasantsAmount = 0;

    public Peasant(Player side, BoardField location){
        super(side, location);
        this.hitPoints = 4;

        if (side.equals(Player.RED)) {
            id = redPeasantsAmount;
            redPeasantsAmount++;
        } else {
            id = bluePeasantsAmount;
            bluePeasantsAmount++;
        }
    }
}
