package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class Knight extends MilitaryUnit {

    public Knight(Player side, BoardField location){
        super(side, location);
        this.hitPoints = 20;
        this.attackStrength = 6;
        this.range = 1;
    }
}
