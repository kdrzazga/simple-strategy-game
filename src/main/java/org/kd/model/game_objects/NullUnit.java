package org.kd.model.game_objects;

import org.kd.model.BoardField;
import org.kd.model.Player;

public class NullUnit extends Unit {
    public NullUnit(BoardField location) {
        super(Player.NONE, location);
    }
}
