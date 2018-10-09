package org.kd.model;

import org.kd.model.game_objects.*;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class UnitsFactory {

    public List<Peasant> createPeasantsOnDefaultPositions(Board board, Player side, int amount, int shiftDown) {

        int xCoordinate = (side.equals(Player.RED)) ? 1 : board.COLUMN_SIZE - 2;

        List<Peasant> peasants = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Peasant newPeasant = new Peasant(side, new BoardField(board, xCoordinate, y + shiftDown));
            peasants.add(newPeasant);
        });

        return peasants;
//    throw new NotImplementedYetException();
    }

    public List<Archer> createArchersOnDefaultPositions(Board board, Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 2 : board.COLUMN_SIZE - 3;
        List<Archer> archers = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Archer newPeasant = new Archer(side, new BoardField(board, xCoordinate, y));
            archers.add(newPeasant);
        });

        return archers;
    }

    public List<Knight> createKnightsOnDefaultPositions(Board board, Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 3 : board.COLUMN_SIZE - 4;
        List<Knight> knights = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Knight newPeasant = new Knight(side, new BoardField(board, xCoordinate, y));
            knights.add(newPeasant);
        });

        return knights;
    }

    public List<Swordsman> createSwordsmenOnDefaultPositions(Board board, Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 4 : board.COLUMN_SIZE - 5;
        List<Swordsman> swordsmen = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Swordsman newUnit = new Swordsman(side, new BoardField(board, xCoordinate, y));
            swordsmen.add(newUnit);
        });

        return swordsmen;
    }

    /*public Unit createFromString(String unitName){

    }*/
}
