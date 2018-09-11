package org.kd.view;

import org.kd.model.Board;
import org.kd.model.Output;
import org.kd.model.Player;
import org.kd.model.game_objects.*;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

import static org.kd.lib.Sout.println;
import static org.kd.lib.Sout.print;

public class TextOutput implements Output {

    private final PrintStream out;
    private static final Map<Class<? extends Unit>, Character> unitSymbolMap = new Hashtable<>();
    private static final Map<Player, String> playerSymbolMap = new Hashtable<>();
    private static final Map<Player, String> playerColorMap = new Hashtable<>();

    static {
        unitSymbolMap.put(Peasant.class, 'P');
        unitSymbolMap.put(Archer.class, 'A');
        unitSymbolMap.put(Swordsman.class, 'S');
        unitSymbolMap.put(Knight.class, 'K');

        playerSymbolMap.put(Player.BLUE, "b");
        playerSymbolMap.put(Player.RED, "r");

        playerColorMap.put(Player.BLUE, TextOutputColors.BLUE_COLOR);
        playerColorMap.put(Player.RED, TextOutputColors.RED_COLOR);
        playerColorMap.put(Player.NONE, TextOutputColors.INFO_COLOR);

    }

    public TextOutput() {
        out = System.out;
    }

    @Override
    public void draw(Board board) {
        print(out, ' ', 4);
        drawHorizontalLine();
        for (int c = 0; c < Board.ROW_SIZE; c++) {
            final int col = c;
            IntStream.range(0, Board.COLUMN_SIZE)
                    .forEach(row -> drawBoardField(board, col, row));
            out.println('|');
            print(out, ' ', 4);
            drawHorizontalLine();
        }
    }

    private void drawHorizontalLine() {
        println(out, '-', 4 * Board.COLUMN_SIZE);
    }

    private void drawBoardField(Board board, int col, int row) {
        if (row == 0) out.format("%03d", col + 1);
        out.print("|");

        Iterator<Unit> unitIterator = board.getAllUnits().iterator();

        boolean found = false;
        while (unitIterator.hasNext()) {
            Unit unit = unitIterator.next();
            if (unit.location.getTableXCoord() == row
                    && unit.location.getTableYCoord() == col) {
                out.print(unitToString(unit));
                found = true;
            }
        }
        if (!found) System.out.print("   ");
    }

    private String unitToString(Unit unit) {

        return playerColorMap.get(unit.getSide())
                + playerSymbolMap.get(unit.getSide())
                + unitSymbolMap.get(unit.getClass())
                + unit.getId()
                + TextOutputColors.END_COLOUR;
    }
}
