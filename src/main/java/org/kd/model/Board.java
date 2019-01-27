package org.kd.model;

import org.kd.model.game_objects.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Board {

    public final short COLUMN_SIZE = 45;
    public final short ROW_SIZE = 170;

    List<Peasant> peasants = new LinkedList<>();
    List<Swordsman> swordsmen = new LinkedList<>();
    List<Archer> archers = new LinkedList<>();
    List<Knight> knights = new LinkedList<>();
    List<Farm> farms = new LinkedList<>();
    List<Barracks> barracks = new LinkedList<>();


    public GameObject getObjectAt(BoardField location) {

        for (GameObject gameObject : getAllObjects()) {
            if (gameObject.location.equals(location))
                return gameObject;
        }
        return new NullGameObject(location);
    }

    private Iterable<? extends GameObject> getAllObjects() {
        List<GameObject> allObjects = new ArrayList<>(peasants.size() + swordsmen.size() + archers.size() + knights.size() + knights.size() + farms.size() + barracks.size());
        allObjects.addAll(peasants);
        allObjects.addAll(swordsmen);
        allObjects.addAll(archers);
        allObjects.addAll(knights);
        allObjects.addAll(farms);
        allObjects.addAll(barracks);

        return allObjects;
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
        List<Unit> allUnitsOf1Player = new LinkedList<>();
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
