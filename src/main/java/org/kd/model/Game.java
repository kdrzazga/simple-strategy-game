package org.kd.model;

public class Game {

    public Player redPlayer;
    public Player bluePlayer;

    public Output output;

    public Board board;

    private long currentTurnNumber;
    private Player turn;

    public Game(Output output){
        board = new BoardFactory().createBalancedBoard();
        this.output = output;
    }

    public void draw(){
        output.draw(board);
    }
    public void nextTurn(){
        currentTurnNumber++;
    }

    public void start(){
        this.currentTurnNumber = 0;
        this.turn = Player.RED;

        draw();
    }
}
