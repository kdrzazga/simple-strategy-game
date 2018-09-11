package org.kd.model;

import org.kd.model.game_objects.*;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Board {

    public final static short COLUMN_SIZE = 45;
    public final static short ROW_SIZE = 170;

    List<Peasant> peasants = new Vector<>();
    List<Swordsman> swordsmen = new Vector<>();
    List<Archer> archers = new Vector<>();
    List<Knight> knights = new Vector<>();
    List<Farm> farms = new Vector<>();
    List<Barracks> barracks = new Vector<>();

    public Unit getUnitAt(BoardField location) {

        for (Unit unit : getAllUnits()) {
            if (unit.location.equals(location))
                return unit;
        }
        return new NullUnit(location);
    }

    public List<Peasant> getPeasants(Player side) {
        return peasants
                .stream()
                .filter(peasant -> peasant.getSide().equals(side))
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }

    public List<Swordsman> getSwordsmen(Player side) {
        return swordsmen
                .stream()
                .filter(peasant -> peasant.getSide().equals(side))
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }
    public List<Archer> getArchers(Player side) {
        return archers
                .stream()
                .filter(peasant -> peasant.getSide().equals(side))
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }

    public List<Knight> getKnights(Player side) {
        return knights
                .stream()
                .filter(peasant -> peasant.getSide().equals(side))
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }

    public List<Farm> getFarms(Player side) {
        return farms
                .stream()
                .filter(peasant -> peasant.getSide().equals(side))
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }

    public List<Barracks> getBarracks(Player side) {
        return barracks
                .stream()
                .filter(peasant -> peasant.getSide().equals(side))
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }

    public List<Unit> getAllUnits() {
        List<Unit> allUnits = getAllUnits(Player.RED);
        allUnits.addAll(getAllUnits(Player.BLUE));
        return allUnits;
    }

    public List<Unit> getAllUnits(Player side) {
        List<Unit> allUnitsOf1Player = new Vector<>();
        allUnitsOf1Player.addAll(getPeasants(side));
        allUnitsOf1Player.addAll(getArchers(side));
        allUnitsOf1Player.addAll(getSwordsmen(side));
        allUnitsOf1Player.addAll(getKnights(side));

        return allUnitsOf1Player
                .stream()
                .filter(GameObject::isAlive)
                .collect(Collectors.toList());
    }

}
