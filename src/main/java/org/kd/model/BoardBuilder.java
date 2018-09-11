package org.kd.model;

public class BoardBuilder {

    private static Board board;

    public BoardBuilder() {
        board = new Board();
    }

    public BoardBuilder createStandardBoard() {
        board.peasants = new UnitsFactory().createPeasantsOnDefaultPositions(Player.BLUE, 1, 0);
        board.peasants.addAll(new UnitsFactory().createPeasantsOnDefaultPositions(Player.RED, 1, 0));
        return this;
    }

    public BoardBuilder withPeasants(Player side, int amount) {
        board.peasants.addAll(new UnitsFactory().createPeasantsOnDefaultPositions(side, amount - 1, 1));
        return this;
    }

    public BoardBuilder withArchers(Player side, int amount) {
        board.archers.addAll(new UnitsFactory().createArchersOnDefaultPositions(side, amount));
        return this;
    }

    public BoardBuilder withSwordsmen(Player side, int amount) {
        board.swordsmen.addAll(new UnitsFactory().createSwordsmenOnDefaultPositions(side, amount));
        return this;
    }

    public BoardBuilder withKnights(Player side, int amount) {
        board.knights.addAll(new UnitsFactory().createKnightsOnDefaultPositions(side, amount ));
        return this;
    }

    public Board build() {
        return board;
    }


}
