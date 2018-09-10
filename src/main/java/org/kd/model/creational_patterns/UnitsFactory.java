package org.kd.model.creational_patterns;

import org.kd.model.Board;
import org.kd.model.BoardField;
import org.kd.model.Player;
import org.kd.model.game_objects.Archer;
import org.kd.model.game_objects.Knight;
import org.kd.model.game_objects.Peasant;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class UnitsFactory {

    public List<Peasant> createPeasantsOnDefaultPositions(Player side, int amount, int shiftDown) {

        int xCoordinate = (side.equals(Player.RED)) ? 1 : Board.COLUMN_SIZE - 1;

        List<Peasant> peasants = new Vector<>(amount);

        IntStream.range(1, amount).forEach(y -> {
            Peasant newPeasant = new Peasant(side, new BoardField(xCoordinate, y + shiftDown));
            peasants.add(newPeasant);
        });

        return peasants;
    }

    public List<Archer> createArchersOnDefaultPositions(Player side, int amount){
        int xCoordinate = (side.equals(Player.RED)) ? 1 : Board.COLUMN_SIZE - 1;
        List<Archer> archers = new Vector<>(amount);

        IntStream.range(1, amount).forEach(y -> {
            Archer newPeasant = new Archer(side, new BoardField(xCoordinate, y));
            archers.add(newPeasant);
        });

        return archers;
    }
    public List<Knight> createKnightsOnDefaultPositions(Player side, int amount){
        int xCoordinate = (side.equals(Player.RED)) ? 1 : Board.COLUMN_SIZE - 1;
        List<Knight> knights = new Vector<>(amount);

        IntStream.range(1, amount).forEach(y -> {
            Knight newPeasant = new Knight(side, new BoardField(xCoordinate, y));
            knights.add(newPeasant);
        });

        return knights;
    }
}
