package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.GameObject;
import org.kd.model.Player;

public class Unit extends GameObject {

    public Unit(Player side, BoardField location){
        super(location);
        this.side = side;
    }

    public BoardField orderedLocation;

}