package org.kd.model;

import org.kd.model.Board;
import org.kd.model.BoardField;
import org.kd.model.Player;
import org.kd.model.game_objects.Archer;
import org.kd.model.game_objects.Knight;
import org.kd.model.game_objects.Peasant;
import org.kd.model.game_objects.Swordsman;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class UnitsFactory {

    public List<Peasant> createPeasantsOnDefaultPositions(Player side, int amount, int shiftDown) {

        int xCoordinate = (side.equals(Player.RED)) ? 1 : Board.COLUMN_SIZE - 2;

        List<Peasant> peasants = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Peasant newPeasant = new Peasant(side, new BoardField(xCoordinate, y + shiftDown));
            peasants.add(newPeasant);
        });

        return peasants;
    }

    public List<Archer> createArchersOnDefaultPositions(Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 2 : Board.COLUMN_SIZE - 3;
        List<Archer> archers = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Archer newPeasant = new Archer(side, new BoardField(xCoordinate, y));
            archers.add(newPeasant);
        });

        return archers;
    }

    public List<Knight> createKnightsOnDefaultPositions(Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 3 : Board.COLUMN_SIZE - 4;
        List<Knight> knights = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Knight newPeasant = new Knight(side, new BoardField(xCoordinate, y));
            knights.add(newPeasant);
        });

        return knights;
    }

    public List<Swordsman> createSwordsmenOnDefaultPositions(Player side, int amount) {
        int xCoordinate = (side.equals(Player.RED)) ? 4 : Board.COLUMN_SIZE - 5;
        List<Swordsman> swordsmen = new Vector<>(amount);

        IntStream.range(0, amount).forEach(y -> {
            Swordsman newUnit = new Swordsman(side, new BoardField(xCoordinate, y));
            swordsmen.add(newUnit);
        });

        return swordsmen;
    }
}
