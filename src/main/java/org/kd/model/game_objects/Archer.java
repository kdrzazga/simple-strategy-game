package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class Archer extends MilitaryUnit  {

    public Archer(Player side, BoardField location){
        super(side, location);
        this.hitPoints = 10;
        this.attackStrength = 2;
        this.range = 4;
    }
}
