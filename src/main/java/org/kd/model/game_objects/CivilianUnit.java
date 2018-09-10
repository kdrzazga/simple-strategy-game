package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class CivilianUnit extends Unit{

    public CivilianUnit(Player side, BoardField location){
        super(side, location);
    }
}
