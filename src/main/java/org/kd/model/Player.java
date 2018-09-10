package org.kd.model;

import org.kd.model.game_objects.Building;
import org.kd.model.game_objects.Unit;

import java.util.List;

public enum Player {

    BLUE, RED;

    List<Building> buildings;
    List<Unit> units;

}
