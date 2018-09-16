package org.kd.model.orders;

import org.kd.model.BoardField;
import org.kd.model.game_objects.Unit;

public class OrderMove extends Order {

    public OrderMove(Unit unit, BoardField destination){
        this.destination = destination;
        this.unit = unit;
    }

    BoardField destination;
    Unit unit;

    public void execute() {

    }
}
