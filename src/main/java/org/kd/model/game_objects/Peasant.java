package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class Peasant extends CivilianUnit {

    public Peasant(Player side, BoardField location){
        super(side, location);
        this.hitPoints = 4;
    }
}
