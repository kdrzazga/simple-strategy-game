package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class MilitaryUnit extends Unit {

    protected int range;
    protected int attackStrength;

    public MilitaryUnit(Player side, BoardField location) {
        super(side, location);
    }

    public void attack(){

    }
}
