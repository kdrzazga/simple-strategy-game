package org.kd.model;

import org.kd.model.game_objects.*;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class UnitsFactory {

    public List<Peasant> createPeasantsOnDefaultPositions(Board board, Player side, int amount, int shiftDown) {

        int xCoordinate = (side.equals(Player.RED)) ? 1 : board.COLUMN_SIZE - 2;

        var peasants = new Vector<Peasant>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Peasant newPeasant = new Peasant(side, new BoardField(board, xCoordinate, y + shiftDown));
            peasants.add(newPeasant);
        });

        return peasants;
//    throw new NotImplementedYetException();
    }

    public List<Archer> createArchersOnDefaultPositions(Board board, Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 2 : board.COLUMN_SIZE - 3;
        var archers = new Vector<Archer>(amount);

        IntStream.range(0, amount).forEach(y -> {
            var newArcher = new Archer(side, new BoardField(board, xCoordinate, y));
            archers.add(newArcher);
        });

        return archers;
    }

    public List<Knight> createKnightsOnDefaultPositions(Board board, Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 3 : board.COLUMN_SIZE - 4;
        var knights = new Vector<Knight>(amount);

        IntStream.range(0, amount).forEach(y -> {
            var newKnight = new Knight(side, new BoardField(board, xCoordinate, y));
            knights.add(newKnight);
        });

        return knights;
    }

    public List<Swordsman> createSwordsmenOnDefaultPositions(Board board, Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 4 : board.COLUMN_SIZE - 5;
        var swordsmen = new Vector<Swordsman>(amount);

        IntStream.range(0, amount).forEach(y -> {
            var newUnit = new Swordsman(side, new BoardField(board, xCoordinate, y));
            swordsmen.add(newUnit);
        });

        return swordsmen;
    }

    /*public Unit createFromString(String unitName){

    }*/
}
