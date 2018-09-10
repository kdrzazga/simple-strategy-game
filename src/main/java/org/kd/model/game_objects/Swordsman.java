package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class Swordsman extends MilitaryUnit  {
    public Swordsman(Player side, BoardField location){
        super(side, location);
        this.hitPoints = 12;
        this.range = 1;
        this.attackStrength = 4;
    }
}
