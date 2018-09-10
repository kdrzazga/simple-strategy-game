package org.kd.model;

import org.kd.model.game_objects.*;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Board {

    public final static short COLUMN_SIZE = 150;
    public final static short ROW_SIZE = 200;

     List<Peasant> peasants = new Vector<>();
     List<Swordsman> swordsmen = new Vector<>();
     List<Knight> knights = new Vector<>();
     List<Farm> farms = new Vector<>();
     List<Barracks> barracks = new Vector<>();

    public List<Peasant> getPeasants(Player side) {
        return peasants
                .stream()
                .filter(peasant -> peasant.side.equals(side))
                .filter(peasant -> peasant.isAlive())
                .collect(Collectors.toList());
    }

    public List<Swordsman> getSwordsmen(Player side) {
        return swordsmen
                .stream()
                .filter(peasant -> peasant.side.equals(side))
                .filter(peasant -> peasant.isAlive())
                .collect(Collectors.toList());
    }

    public List<Knight> getKnights(Player side) {
        return knights
                .stream()
                .filter(peasant -> peasant.side.equals(side))
                .filter(peasant -> peasant.isAlive())
                .collect(Collectors.toList());
    }
    public List<Farm> getFarms(Player side) {
        return farms
                .stream()
                .filter(peasant -> peasant.side.equals(side))
                .filter(peasant -> peasant.isAlive())
                .collect(Collectors.toList());
    }
    public List<Barracks> getBarracks(Player side) {
        return barracks
                .stream()
                .filter(peasant -> peasant.side.equals(side))
                .filter(peasant -> peasant.isAlive())
                .collect(Collectors.toList());
    }
}
